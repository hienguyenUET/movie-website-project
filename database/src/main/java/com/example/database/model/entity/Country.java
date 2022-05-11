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
    private long id;

    @Column
    private String countryName;

    @ManyToMany
    @JoinTable(
            name = "movie_country",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies;

    public CountryDto toDto() {
        return CountryDto.builder()
                .id(id)
                .countryName(countryName)
                .build();
    }
}
