package com.example.database.api.form;

import lombok.Data;

import java.util.List;

@Data
public class ActorForm {
    private long id;

    private String name;

    private List<Long> filmId;
}
