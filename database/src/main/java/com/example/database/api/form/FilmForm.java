package com.example.database.api.form;

import com.example.database.model.entity.*;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class FilmForm {
    private long id;

    private String homepage;

    private String title;

    private String image;

    private Date productionDate;

    private List<Long> actorId;

    private long typeId;

    private Long countryId;

}
