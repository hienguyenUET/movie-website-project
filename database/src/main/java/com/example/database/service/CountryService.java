package com.example.database.service;

import com.example.database.api.form.CountryForm;
import com.example.database.model.entity.Country;

import java.util.List;

public interface CountryService {
    Country addNewCountry(CountryForm countryForm);

    void deleteCountry(Long id);

    Country getById(Long id);

    List<Country> getCountryList();

    Country save(Country country);
}
