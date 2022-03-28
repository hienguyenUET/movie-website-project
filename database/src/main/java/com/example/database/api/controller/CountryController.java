package com.example.database.api.controller;

import com.example.database.api.form.CountryForm;
import com.example.database.api.response.ApiResponse;
import com.example.database.model.dto.CountryDto;
import com.example.database.model.entity.Country;
import com.example.database.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("country/api")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping
    public ResponseEntity<ApiResponse> addUser(@RequestBody CountryForm countryForm) {
        Country country = countryService.addNewCountry(countryForm);
        CountryDto dto = country.toDto();
        ApiResponse response = ApiResponse.success(country, HttpStatus.OK.value(), "Thêm đất nước thành công");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getUserList() {
        List<Country> countries = countryService.getCountryList();
        List<CountryDto> dto = countries.stream().map(Country::toDto).collect(Collectors.toList());
        ApiResponse response = ApiResponse.success(dto, HttpStatus.OK.value(), "Danh sách các đất nước");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getCountryById(@PathVariable long id) {
        Country country = countryService.getById(id);
        CountryDto dto = country.toDto();
        ApiResponse response = ApiResponse.success(dto,HttpStatus.OK.value(), String.format("Đất nước %d",id));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCountry(@PathVariable long id) {
        countryService.deleteCountry(id);
        ApiResponse response = ApiResponse.success(null,HttpStatus.OK.value(), "Xóa thành công đát nước: " + id);
        return ResponseEntity.ok(response);
    }
}
