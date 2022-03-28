package com.example.database.model.entity;

import com.example.database.model.dto.CountryDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<Film> films = new ArrayList<>();


    public CountryDto toDto() {
        return CountryDto.builder()
                .id(id)
                .name(name)
                .films(films)
                .build();
    }
}
