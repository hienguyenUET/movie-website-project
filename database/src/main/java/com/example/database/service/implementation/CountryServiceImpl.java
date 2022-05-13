package com.example.database.service.implementation;

import com.example.database.api.form.CountryForm;
import com.example.database.model.entity.Country;
import com.example.database.repository.CountryRepository;
import com.example.database.repository.MovieRepository;
import com.example.database.service.service.CountryService;
import com.example.database.utils.exception.BadRequestException;
import com.example.database.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Optional<Country> findAllByCountryName(String name) {
        return countryRepository.findAllByCountryName(name);
    }

    @Override
    public Country findByCountryName(String name) {
        return countryRepository.findByCountryName(name);
    }

    @Override
    public Boolean existsByCountryName(String name) {
        return countryRepository.existsByCountryName(name);
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

}
