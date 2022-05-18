package com.example.database.api.controller;

import com.example.database.model.entity.*;
import com.example.database.payload.response.*;
import com.example.database.service.implementation.ActorServiceImpl;
import com.example.database.service.implementation.GenreServiceImpl;
import com.example.database.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.security.Key;
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
    @Autowired
    private KeywordService keywordService;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/idAPI")
    public ResponseEntity<List<String>> getIdAPI() {
        List<Movie> movieIdAPI = movieService.findAll();
        List<String> getMovieIDAPI = new ArrayList<>();
        for (Movie movie : movieIdAPI) {
            getMovieIDAPI.add(movie.getIdAPI());
        }
        if (getMovieIDAPI != null) {
            return new ResponseEntity<>(getMovieIDAPI, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // return all movies in database
    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getMovie() {
        List<Movie> movies = movieService.findAll();
        if (movies.size() > 0) {
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/details/{idAPI}")
    public ResponseEntity<Movie> getMovieDetails(@PathVariable String idAPI) {
        Movie movie = movieService.findByIdAPI(idAPI);
        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //get keywords for single movie
    @GetMapping("/keywords")
    public List<Keyword> getMovieKeyword(long id) {
        List<Keyword> keywords = new ArrayList<>();
        String keywordInfo = "https://api.themoviedb.org/3/movie/" + id + "/keywords?api_key=606b350a5be7a4ff1de563e915b76a18";
        ResponseEntity<KeywordResultResponse> response = restTemplate.exchange(
                keywordInfo,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<KeywordResultResponse>() {
                    @Override
                    public Type getType() {
                        return super.getType();
                    }
                }
        );

        KeywordResultResponse res = response.getBody();

        assert res != null;
        for (KeywordResponseBody r : res.getResponse()) {
            if (!keywordService.existsByName(r.getName())) {
                Keyword keyword = new Keyword();
                keyword.setName(r.getName());
                keywordService.save(keyword);
            }
            Keyword keyword = keywordService.findByName(r.getName());
            keywords.add(keyword);
        }
        return keywords;

    }

    @GetMapping("/action")
    public ResponseEntity<List<Movie>> getActionMovies() {
        List<Movie> movies = movieService.findByGenre_GenreName("Action");
        if (movies.size() > 0) {
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/adventure")
    public ResponseEntity<List<Movie>> getAdventureMovies() {
        List<Movie> movies = movieService.findByGenre_GenreName("Adventure");
        if (movies.size() > 0) {
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/horror")
    public ResponseEntity<List<Movie>> getHorrorMovies() {
        List<Movie> movies = movieService.findByGenre_GenreName("Horror");
        if (movies.size() > 0) {
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/comedy")
    public ResponseEntity<List<Movie>> getComedyMovies() {
        List<Movie> movies = movieService.findByGenre_GenreName("Comedy");
        if (movies.size() > 0) {
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
//    @PreAuthorize("hasRole('ADMIN')")
    public void getMovies() {
        for (int i = 1; i < 6; i++) {
            ResponseEntity<TMDBResultResponse> responseEntity = restTemplate.exchange(
                    "https://api.themoviedb.org/3/discover/movie?api_key=73b750a9c1721e4bce1ae7fc3a32c1a2&with_genres=27&page=" + i,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<TMDBResultResponse>() {
                        @Override
                        public Type getType() {
                            return super.getType();
                        }
                    }
            );
            TMDBResultResponse IMDBResultResponse = responseEntity.getBody();
            System.out.println(responseEntity.getBody());
            // check if ac
            for (int j = 0; j < IMDBResultResponse.getResult().size(); j++) {
                Movie movie = getMovieInfo(IMDBResultResponse.getResult().get(j).getId());
                if (movie != null) {
                    movieService.save(movie);
                }
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

    public Movie getMovieInfo(long id) {
        // get single movie details
        String movieInfo = "https://api.themoviedb.org/3/movie/" + id + "?api_key=606b350a5be7a4ff1de563e915b76a18&language=en-US";
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
        MovieResponseBody body = responseEntity.getBody();
        Movie movie = new Movie();
        assert body != null;
        if (body.getTitle() == null || body.getImdbID() == null || movieService.existsByIdAPI(body.getImdbID())) {
            return null;
        } else {
            movie.setTitle(body.getTitle());
            movie.setOverview(body.getOverview());
            movie.setRuntime(body.getRuntime() + " minutes");
            movie.setReleaseDate(body.getReleaseDate());
            movie.setIdAPI(body.getImdbID());
            movie.setHomepage(body.getHomepage());
            movie.setPosterPath("https://image.tmdb.org/t/p/original/" + body.getPosterPath());
            // add genres to movie
            List<Genre> genres = new ArrayList<>();
            for (GenreResponseBody res : body.getGenres()) {
                Genre genre = checkExistGenre(res.getName());
                genres.add(genre);
            }
            movie.setGenre(genres);
            // add production companies to movie
            List<Company> companies = new ArrayList<>();
            for (CompanyResponseBody res : body.getCompanies()) {
                Company company = checkExistCompany(res.getName());
                companies.add(company);
            }
            movie.setCompanies(companies);
            // add countries to movie
            List<Country> countries = new ArrayList<>();
            for (CountryResponseBody res : body.getCountries()) {
                Country country = checkExistCountry(res.getName());
                countries.add(country);
            }
            movie.setCountries(countries);
            // add languages to movie
            List<Language> languages = new ArrayList<>();
            for (LanguageResponseBody res : body.getLanguages()) {
                Language language = checkExistLanguage(res.getName());
                languages.add(language);
            }
            movie.setLanguages(languages);
            // add actor to movies
            if (checkExistActor(id) != null) {
                movie.setActors(checkExistActor(id));
            }

            if (getMovieKeyword(id) != null) {
                movie.setKeywords(getMovieKeyword(id));
            }
        }
        return movie;
    }


    // check if actor existing in database. If it hasn't, create new record
    public List<Actor> checkExistActor(long id) {
        List<Actor> actors = new ArrayList<>();
        String actorInfo = "https://api.themoviedb.org/3/movie/" + id + "/credits?api_key=606b350a5be7a4ff1de563e915b76a18&language=en-US";
        ResponseEntity<ActorResultResponse> responseEntity = restTemplate.exchange(
                actorInfo,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ActorResultResponse>() {
                    @Override
                    public Type getType() {
                        return super.getType();
                    }
                }
        );

        ActorResultResponse res = responseEntity.getBody();

        for (int i = 0; i < res.getActorResponseBodies().size(); i++) {
            if (!actorService.existsByName(res.getActorResponseBodies().get(i).getName())) {
                Actor actor = new Actor();
                ActorResponseBody actorResponseBody = res.getActorResponseBodies().get(i);
                actor.setName(res.getActorResponseBodies().get(i).getName());
                actor.setCharacterName(res.getActorResponseBodies().get(i).getCharacterName());
                actor.setProfilePath("https://image.tmdb.org/t/p/original/" + res.getActorResponseBodies().get(i).getImage());
                actor.setBiography(res.getActorResponseBodies().get(i).getBiography());
                actor.setDateOfBirth(actorResponseBody.getDateOfBirth());
                actor.setPlaceOfBirth(actorResponseBody.getPlaceOfBirth());
                actorService.save(actor);
            }
            Actor actor = actorService.findActorByName(res.getActorResponseBodies().get(i).getName());
            actors.add(actor);
        }
        return actors;
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
