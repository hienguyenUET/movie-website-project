package com.example.database.api.controller;

import com.example.database.api.form.FilmForm;
import com.example.database.api.response.ApiResponse;
import com.example.database.model.dto.FilmDto;
import com.example.database.model.entity.Film;
import com.example.database.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("film/api")
public class FilmController {
    @Autowired
    FilmService filmService;

    @PostMapping
    public ResponseEntity<ApiResponse> addFilm(@RequestBody FilmForm filmForm) {
        Film film = filmService.addNewFilm(filmForm);
        FilmDto dto = film.toDto();
        ApiResponse response = ApiResponse.success(film, HttpStatus.OK.value(), "Thêm phim thành công");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getFilmList() {
        List<Film> films = filmService.getFilmList();
        List<FilmDto> dto = films.stream().map(Film::toDto).collect(Collectors.toList());
        ApiResponse response = ApiResponse.success(dto, HttpStatus.OK.value(), "Danh sách các phim");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteFilm(@PathVariable long id) {
        filmService.deleteFilm(id);
        ApiResponse response = ApiResponse.success(null,HttpStatus.OK.value(), "Xóa thành công phim: " + id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getFilmById(@PathVariable long id) {
        Film film = filmService.getById(id);
        FilmDto dto = film.toDto();
        ApiResponse response = ApiResponse.success(dto,HttpStatus.OK.value(), String.format("Thể loại %d",id));
        return ResponseEntity.ok(response);
    }

}
