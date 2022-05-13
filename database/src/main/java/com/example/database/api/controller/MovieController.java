package com.example.database.api.controller;

import com.example.database.model.entity.*;
import com.example.database.payload.response.ActorResponseBody;
import com.example.database.payload.response.IMDBResponseBody;
import com.example.database.payload.response.IMDBResultResponse;
import com.example.database.payload.response.MovieResponseBody;
import com.example.database.service.implementation.ActorServiceImpl;
import com.example.database.service.implementation.GenreServiceImpl;
import com.example.database.service.service.CompanyService;
import com.example.database.service.service.CountryService;
import com.example.database.service.service.LanguageService;
import com.example.database.service.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private GenreServiceImpl genreService;
    @Autowired
    private ActorServiceImpl actorService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private LanguageService languageService;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "/get/admin", produces = MediaType.APPLICATION_JSON_VALUE)
//    @PreAuthorize("hasRole('ADMIN')")
    public void getMovies() {
        ResponseEntity<IMDBResultResponse> responseEntity = restTemplate.exchange(
                "https://imdb-api.com/API/AdvancedSearch/k_x5llo480/?genres=horror&title_type=feature",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<IMDBResultResponse>() {
                    @Override
                    public Type getType() {
                        return super.getType();
                    }
                }
        );
        IMDBResultResponse IMDBResultResponse = responseEntity.getBody();
        // check if ac
//        for (int i = 0; i < Objects.requireNonNull(movieResultResponse).getResult().size(); i++) {
        for (int i = 0; i < IMDBResultResponse.getResult().size(); i++) {
            IMDBResponseBody IMDBResponseBody = IMDBResultResponse.getResult().get(i);
            Movie movie = getMovieInfo(IMDBResponseBody.getId());
            if (movie == null) {
                continue;
            } else {
//                System.out.println(movie);
                movieService.save(movie);
            }
        }
    }

    @GetMapping("/getMovies")
    public ResponseEntity<List<Movie>> getMovieList() {
        List<Movie> movies = movieService.findAll();
        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + ' ' + movie.getCompanies());
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    public Movie getMovieInfo(String id) {
        // get single movie details
        String API_KEY = "k_ld2vf6fv";
        String movieInfo = "https://imdb-api.com/en/API/Title/" + API_KEY + '/' + id;
        ResponseEntity<MovieResponseBody> responseEntity = restTemplate.exchange(
                movieInfo,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<MovieResponseBody>() {
                    @Override
                    public Type getType() {
                        return super.getType();
                    }
                }
        );
        MovieResponseBody responseBody = responseEntity.getBody();
        System.out.println(responseBody);
        assert responseBody != null;
        if (responseBody.getGenres() == null || responseBody.getActors() == null || responseBody.getCompanies() == null
                || responseBody.getLanguages() == null || responseBody.getFullTitle() == null
                || responseBody.getCountries() == null || responseBody.getPlot() == null) {
            return null;
        } else {
            Movie movie = new Movie();
            if (responseBody.getRuntimeStr() == null) {
                movie.setRuntime("null");
            } else {
                movie.setRuntime(responseBody.getRuntimeStr());
            }
            movie.setIdAPI(id);
            movie.setTitle(responseBody.getFullTitle());
//            String[] tempActor = responseBody.getActors().split(", ");
            List<Actor> actors = new ArrayList<>();
            for (ActorResponseBody name : responseBody.getActors()) {
                Actor actor = new Actor();
                actor.setName(name.getName());
                actors.add(actor);
            }
            String[] tempGenre = responseBody.getGenres().split(", ");
            List<Genre> genres = new ArrayList<>();
            for (String name : tempGenre) {
                Genre genre = checkExistGenre(name);
                genres.add(genre);
            }
            String[] tempCompany = responseBody.getCompanies().split(", ");
            List<Company> companies = new ArrayList<>();
            for (String name : tempCompany) {
                Company company = checkExistCompany(name);
                companies.add(company);
            }
            String[] tempCountry = responseBody.getCountries().split(", ");
            List<Country> countries = new ArrayList<>();
            for (String name : tempCountry) {
                Country country = checkExistCountry(name);
                countries.add(country);
            }
            String[] tempLanguage = responseBody.getLanguages().split(", ");
            List<Language> languages = new ArrayList<>();
            for (String name : tempLanguage) {
                Language language = checkExistLanguage(name);
                languages.add(language);
            }
            movie.setRuntime(responseBody.getRuntimeStr());
            movie.setActors(actors);
            movie.setGenre(genres);
            movie.setCompanies(companies);
            movie.setCountries(countries);
            movie.setReleaseDate(responseBody.getReleaseDate());
            movie.setPlot(responseBody.getPlot());
            movie.setLanguages(languages);
            return movie;
        }
    }

    // check if actor existing in database. If it hasn't, create new record
    public Actor checkExistActor(String name) {
        if (!actorService.existsByName(name)) {
            Actor actor = new Actor();
            actor.setName(name);
            actorService.save(actor);
        }
        return actorService.findActorByName(name);
    }

    // check if genre existing in database. If it hasn't, create new record
    public Genre checkExistGenre(String name) {
        if (!genreService.existsByGenreName(name)) {
            Genre genre = new Genre();
            genre.setGenreName(name);
            genreService.save(genre);
        }
        return genreService.findByGenreName(name);
    }

    // check if country existing in database. If it hasn't, create new record
    public Country checkExistCountry(String name) {
        if (!countryService.existsByCountryName(name)) {
            Country country = new Country();
            country.setCountryName(name);
            countryService.save(country);
        }
        return countryService.findByCountryName(name);
    }

    // check if language existing in database. If it hasn't, create new record
    public Language checkExistLanguage(String name) {
        if (!languageService.existsByLanguageName(name)) {
            Language language = new Language();
            language.setLanguageName(name);
            languageService.save(language);
        }
        return languageService.findByLanguageName(name);
    }

    // check if company existing in database. If it hasn't, create a new record
    public Company checkExistCompany(String name) {
        if (!companyService.existsByCompanyName(name)) {
            Company company = new Company();
            company.setCompanyName(name);
            companyService.save(company);
        }
        return companyService.findByCompanyName(name);
    }
}
