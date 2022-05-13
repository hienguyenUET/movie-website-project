package com.example.database.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class JSONTemplate {
    @JsonProperty("Search")
    private List<Movie> movies;
    private String totalResults;
    @JsonProperty("Response")
    private String response;

    @Override
    public String toString() {
        return "JSONTemplate{" +
                "movies=" + movies +
                ", totalResults='" + totalResults + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
