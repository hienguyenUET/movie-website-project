package com.example.database.service.Impl;

import com.example.database.api.form.CountryForm;
import com.example.database.model.entity.Country;
import com.example.database.repository.CountryRepository;
import com.example.database.repository.FilmRepository;
import com.example.database.service.CountryService;
import com.example.database.utils.exception.BadRequestException;
import com.example.database.utils.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryService countryService;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    FilmRepository filmRepository;

    @Override
    public Country addNewCountry(CountryForm countryForm) {
        if(!StringUtils.hasText(countryForm.getName())) {
            String mess = "Invalid argument";
            throw new BadRequestException(mess);
        }

        Country country = Country.builder()
                .name(countryForm.getName())
                .build();

        return save(country);
    }

    @Override
    public void deleteCountry(Long id) {
        Country country = countryRepository.findById(id).get();
        if(ObjectUtils.isEmpty(country)) {
            String mess = "country-not-exits";
            throw new NotFoundException(mess);
        }

        countryRepository.deleteById(id);
    }

    @Override
    public Country getById(Long id) {
        Country country = countryRepository.findById(id).get();
        if(ObjectUtils.isEmpty(country)) {
            String mess = "country-not-exits";
            throw new NotFoundException(mess);
        }

        return country;
    }

    @Override
    public List<Country> getCountryList() {
        List<Country> countries = (List<Country>) countryRepository.findAll();
        if(ObjectUtils.isEmpty(countries)) {
            return Collections.EMPTY_LIST;
        }

        return countries;
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }
}
