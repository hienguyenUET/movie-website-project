package com.example.database.model.entity;

import com.example.database.model.dto.CountryDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.thymeleaf.expression.Lists;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Table(name = "country")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "country_id")
    private long id;

    @Column
    private String countryName;


    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
//                ", movies=" + movies +
                '}';
    }
}
