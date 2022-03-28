package com.example.database.model.dto;

import com.example.database.model.entity.Film;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class UserDto implements Serializable {
    private Long id;
    private String name;
    private String password;
    private List<Film> films;
}
