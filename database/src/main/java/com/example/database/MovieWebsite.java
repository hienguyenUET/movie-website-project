package com.example.database;

import com.example.database.format.DateFormatByJson;
import com.example.database.model.entity.Actor;
import com.example.database.model.entity.Genre;
import com.example.database.model.entity.JSONTemplate;
import com.example.database.model.entity.Movie;
import com.example.database.service.service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

// CommandLineRunner: triển khai phương thức chỉ chạy 1 lần duy nhất trong cả vòng đời của ứng dụng


@SpringBootApplication
public class MovieWebsite implements CommandLineRunner {
    @Autowired
    private MovieService movieService;

    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(MovieWebsite.class, args);
    }

    @Override
    public void run(String... args) throws JsonProcessingException {
        ResponseEntity<JSONTemplate> responseEntity = restTemplate.exchange(
                "https://www.omdbapi.com/?s=avengers&apikey=7f478e24",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<JSONTemplate>() {
                    @Override
                    public Type getType() {
                        return super.getType();
                    }
                }
        );
        JSONTemplate template = responseEntity.getBody();
        assert template != null;
        List<Movie> avenger = new ArrayList<>(template.getMovies());

        for (Movie value : avenger) {
            String uri = "http://www.omdbapi.com/?apikey=660ad911&t=" + value.getTitle();
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper objectMapper = new ObjectMapper();
            String movieJson = restTemplate.getForObject(uri, String.class);

            LinkedHashMap<String, String> movies = (LinkedHashMap<String, String>) objectMapper.readValue(movieJson, Object.class);
            Date releaseDate = Date.valueOf(DateFormatByJson.dateFormattedByJson(movies.get("Released")));
            Movie movie = new Movie(movies.get("Title"));
            movie.setReleaseDate(releaseDate);
//            movie.setActors(movies.get("Actors"));
//            String[] actor = movies.get("Actors").split(", ");
//            for (String s : actor) {
//                Actor actor1 = new Actor();
//                actor1.setPersonName(s);
//                movie.addActor(actor1);
//            }
            String[] genres = movies.get("Genre").split(", ");
            for (String s : genres) {
                Genre genre1 = new Genre();
                genre1.setGenreName(s);
                movie.addGenre(genre1);
            }
            movieService.save(movie);

        }
        System.out.println(avenger);
    }
}
