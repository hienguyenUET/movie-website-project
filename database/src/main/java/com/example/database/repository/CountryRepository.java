package com.example.database.repository;

import com.example.database.model.entity.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, Integer> {
    Optional<Country> findAllByCountryName(String name);
    Country findByCountryName(String name);
    Boolean existsByCountryName(String name);
}
