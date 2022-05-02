package com.example.database.model.dto;

import com.example.database.model.entity.Account;
import com.example.database.model.entity.Movie;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class CommentDto implements Serializable {
    private Long id;

    private String content;

    private Movie movie;

    private Account account;
}
