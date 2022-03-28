package com.example.database.api.form;

import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class CountryForm {
    private long id;

    private String name;

    private List<Long> filmId;
}
