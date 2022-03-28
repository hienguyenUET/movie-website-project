package com.example.database.api.form;

import com.example.database.model.entity.Film;
import lombok.Data;

import java.util.List;

@Data
public class ActorForm {
    private long id;

    private String name;

    private List<Long> filmId;
}
