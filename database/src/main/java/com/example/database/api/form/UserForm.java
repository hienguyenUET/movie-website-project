package com.example.database.api.form;

import lombok.Data;

import java.util.List;

@Data
public class UserForm {
    private String name;

    private String password;

    private List<Long> filmId;
}
