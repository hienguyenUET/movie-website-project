//package com.example.database.api.controller;
//
//import com.example.database.api.response.ApiResponse;
//import com.example.database.model.dto.MovieDto;
//import com.example.database.model.entity.Movie;
//import com.example.database.service.service.MovieService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("film/api")
//public class MovieController {
//    @Autowired
//    MovieService movieService;
//
////    @PostMapping
////    public ResponseEntity<ApiResponse> addFilm(@RequestBody FilmForm filmForm) {
////        Movie movie = movieService.addNewFilm(filmForm);
////        MovieDto dto = movie.toDto();
////        ApiResponse response = ApiResponse.success(movie, HttpStatus.OK.value(), "Thêm phim thành công");
////        return ResponseEntity.ok(response);
////    }
//
//    @GetMapping
//    public ResponseEntity<ApiResponse> getFilmList() {
//        List<Movie> movies = movieService.findAll();
//        List<MovieDto> dto = movies.stream().map(Movie::toDto).collect(Collectors.toList());
//        ApiResponse response = ApiResponse.success(dto, HttpStatus.OK.value(), "Danh sách các phim");
//        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<ApiResponse> deleteFilm(@PathVariable int id) {
//        movieService.deleteById(id);
//        ApiResponse response = ApiResponse.success(null,HttpStatus.OK.value(), "Xóa thành công phim: " + id);
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ApiResponse> getFilmById(@PathVariable int id) {
//        Movie movie = movieService.getById(id);
//        MovieDto dto = movie.toDto();
//        ApiResponse response = ApiResponse.success(dto,HttpStatus.OK.value(), String.format("Thể loại %d",id));
//        return ResponseEntity.ok(response);
//    }
//
//}
