package com.example.database.model.entity;

import com.example.database.model.dto.TypeDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "types")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Type {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "type")
    private List<Film> films = new ArrayList<>();

    public TypeDto toDto() {
        return TypeDto.builder()
                .id(id)
                .name(name)
                .films(films)
                .build();
    }
}
