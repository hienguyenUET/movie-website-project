package com.example.database.api.controller;

import com.example.database.MovieWebsite;
import com.example.database.model.dto.MovieDto;
import com.example.database.model.entity.Movie;
import com.example.database.model.entity.User;
import com.example.database.pattern.LazyInitializedSingleton;
import com.example.database.repository.MovieRepository;
import com.example.database.service.implementation.UserDetailsImpl;
import com.example.database.service.service.MovieService;
import com.example.database.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private UserService userService;


    @GetMapping("/info")
    public ResponseEntity<UserDetails> info() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<User> addFavoriteMovie(@PathVariable int id) {
        Movie movie = movieService.findById(id);
        MovieWebsite.user.addFavoriteMovie(movie);
        userService.save(MovieWebsite.user);
        return new ResponseEntity<>(MovieWebsite.user, HttpStatus.OK);
    }

    @GetMapping("/favorite")
    public ResponseEntity<List<MovieDto>> getFavoriteMovies() {
        List<Movie> favoriteMovies = MovieWebsite.user.getFavoriteMovies();
        List<MovieDto> dtos = new ArrayList<>();
        for (Movie movie : favoriteMovies) {
            MovieDto m = new MovieDto();
            m.setId(movie.getId());
            m.setTitle(movie.getTitle());
            m.setProfilePath(movie.getPosterPath());
            m.setReleaseDate(movie.getReleaseDate());
            m.setIdAPI(movie.getIdAPI());
            dtos.add(m);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFavoriteMovie(@PathVariable int id) {
        List<Movie> movies = MovieWebsite.user.getFavoriteMovies();
        Movie movie = movieService.findById(id);
        if (movie == null) {
            throw new RuntimeException("Movie not found in favorite list");
        }
        movies.removeIf(movie1 -> movie1.getId() == movie.getId());
        MovieWebsite.user.setFavoriteMovies(movies);
        userService.save(MovieWebsite.user);
    }
}