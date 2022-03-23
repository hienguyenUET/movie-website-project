package com.example.database.model.dto;

import com.example.database.model.entity.Film;
import com.example.database.model.entity.User;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class CommentDto implements Serializable {
    private Long id;

    private String content;

    private Film film;

    private User user;
}
