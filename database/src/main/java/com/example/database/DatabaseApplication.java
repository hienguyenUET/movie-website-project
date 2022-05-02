package com.example.database;

import com.example.database.format.DateFormatByJson;
import com.example.database.model.entity.Genre;
import com.example.database.model.entity.Movie;
import com.example.database.model.entity.Actor;
import com.example.database.service.service.MovieService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.util.*;

// CommandLineRunner: triển khai phương thức chỉ chạy 1 lần duy nhất trong cả vòng đời của ứng dụng

@JsonIgnoreProperties
@SpringBootApplication
public class DatabaseApplication implements CommandLineRunner {
    @Autowired
    private MovieService movieService;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run(String... args) throws Exception {
        List<String> nameListMoviesList = new ArrayList<>();
        nameListMoviesList.add("Airplane!");
        nameListMoviesList.add("Pan's Labyrinth");
        nameListMoviesList.add("Lawrence Of Arabia");
        nameListMoviesList.add("Trainspotting");
        nameListMoviesList.add("The Silence Of The Lambs");
        nameListMoviesList.add("Interstellar");
        nameListMoviesList.add("Citizen Kane");
        nameListMoviesList.add("Drive");
        nameListMoviesList.add("Gladiator");
        nameListMoviesList.add("One Flew Over The Cuckoo’s Nest");
        nameListMoviesList.add("There Will Be Blood");
        nameListMoviesList.add("Eternal Sunshine Of The Spotless Mind");
        nameListMoviesList.add("12 Angry Men");
        nameListMoviesList.add("Saving Private Ryan");
        nameListMoviesList.add("Mad Max: Fury Road");
        nameListMoviesList.add("The Departed");
        nameListMoviesList.add("The Shining");
        nameListMoviesList.add("Guardians Of The Galaxy");
        nameListMoviesList.add("Schindler’s List");
        nameListMoviesList.add("The Usual Suspects");
        nameListMoviesList.add("Taxi Driver");
        nameListMoviesList.add("Seven");
        nameListMoviesList.add("The Big Lebowski");
        nameListMoviesList.add("Casablanca");
        nameListMoviesList.add("The Good, The Bad And The Ugly");
        nameListMoviesList.add("Heat");
        nameListMoviesList.add("Terminator 2: Judgment Day");
        nameListMoviesList.add("The Matrix");
        nameListMoviesList.add("The Lord Of The Rings: The Two Towers");
        nameListMoviesList.add("Apocalypse Now");
        nameListMoviesList.add("2001: A Space Odyssey");
        nameListMoviesList.add("Die Hard");
        nameListMoviesList.add("Jurassic Park");
        nameListMoviesList.add("Inception");
        nameListMoviesList.add("Fight Club");
        nameListMoviesList.add("The Lord Of The Rings: The Return Of The King");
        nameListMoviesList.add("Aliens");
        nameListMoviesList.add("Alien");
        nameListMoviesList.add("Blade Runner");
        nameListMoviesList.add("The Godfather Part II");
        nameListMoviesList.add("Back To The Future");
        nameListMoviesList.add("The Lord Of The Rings: The Fellowship Of The Ring");
        nameListMoviesList.add("Star Wars: Episode IV — A New Hope");
        nameListMoviesList.add("Jaws");
        nameListMoviesList.add("Raiders Of The Lost Ark");
        nameListMoviesList.add("GoodFellas");
        nameListMoviesList.add("Pulp Fiction");
        nameListMoviesList.add("The Shawshank Redemption");
        nameListMoviesList.add("The Dark Knight");
        nameListMoviesList.add("Star Wars: Episode V — The Empire Strikes Back");
        nameListMoviesList.add("The Godfather");
        nameListMoviesList.add("Stand By Me");
        nameListMoviesList.add("Raging Bull");
        nameListMoviesList.add("Amélie");
        nameListMoviesList.add("Titanic");
        nameListMoviesList.add("Good Will Hunting");
        nameListMoviesList.add("Arrival");
        nameListMoviesList.add("Lost In Translation");
        nameListMoviesList.add("The Princess Bride");
        nameListMoviesList.add("The Terminator");
        nameListMoviesList.add("The Prestige");
        nameListMoviesList.add("No Country For Old Men");
        nameListMoviesList.add("Shaun Of The Dead");
        nameListMoviesList.add("The Exorcist");
        nameListMoviesList.add("Predator");
        nameListMoviesList.add("Indiana Jones And The Last Crusade");
        nameListMoviesList.add("Léon");
        nameListMoviesList.add("Rocky");
        nameListMoviesList.add("True Romance");
        nameListMoviesList.add("Some Like It Hot");
        nameListMoviesList.add("The Social Network");
        nameListMoviesList.add("Spirited Away");
        nameListMoviesList.add("Captain America: Civil War");
        nameListMoviesList.add("Oldboy");
        nameListMoviesList.add("Toy Story");
        nameListMoviesList.add("A Clockwork Orange");
        nameListMoviesList.add("Fargo");
        nameListMoviesList.add("Mulholland Dr.");
        nameListMoviesList.add("Seven Samurai");
        nameListMoviesList.add("Rear Window");
        nameListMoviesList.add("Hot Fuzz");
        nameListMoviesList.add("The Lion King");
        nameListMoviesList.add("Singin’ In The Rain");
        nameListMoviesList.add("Ghostbusters");
        nameListMoviesList.add("Memento");
        nameListMoviesList.add("Star Wars: Return Of The Jedi");
        nameListMoviesList.add("Avengers Assemble");
        nameListMoviesList.add("L.A. Confidential");
        nameListMoviesList.add("Donnie Darko");
        nameListMoviesList.add("La La Land");
        nameListMoviesList.add("Forrest Gump");
        nameListMoviesList.add("American Beauty");
        nameListMoviesList.add("E.T.");
        nameListMoviesList.add("Inglourious Basterds");
        nameListMoviesList.add("Whiplash");
        nameListMoviesList.add("Reservoir Dogs");
        nameListMoviesList.add("Pan’s Labyrinth");
        nameListMoviesList.add("Vertigo");
        nameListMoviesList.add("Psycho");
        nameListMoviesList.add("Once Upon A Time In The West");
        nameListMoviesList.add("It’s a Wonderful Life");
        for (int i = 0; i < nameListMoviesList.size(); i++) {
            nameListMoviesList.get(i);
            String uri = "http://www.omdbapi.com/?apikey=660ad911&t=" + nameListMoviesList.get(i);
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper objectMapper = new ObjectMapper();
            String movieJson = restTemplate.getForObject(uri, String.class);

            LinkedHashMap<String, String> movie = (LinkedHashMap<String, String>) objectMapper.readValue(movieJson, Object.class);
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Date dateReleased = Date.valueOf(DateFormatByJson.dateFormattedByJson(movie.get("Released")));
//            Date dateDvd = Date.valueOf(DateFormatByJson.dateFormattedByJson(movie.get("DVD")));

            Movie movieObject = new Movie(movie.get("Title"));
//            String[] per = movie.get("Actors").split(", ");
//            for (String p : per) {
//                Actor actor = new Actor();
//                actor.setPersonName(p);
//                movieObject.addActor(actor);
//            }
            String[] genre = movie.get("Genre").split(", ");
            for (String g : genre) {
                Genre genre1 = new Genre();
                genre1.setGenreName(g);
                movieObject.addGenre(genre1);
            }
            movieObject.setReleaseDate(dateReleased);
            System.out.println(movieObject);

            movieService.save(movieObject);
        }
    }
}
