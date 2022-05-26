package com.example.database.model.dto;

import com.example.database.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private int id;
    private String idAPI;
    private String title;
    private String profilePath;
    private Date releaseDate;
}
