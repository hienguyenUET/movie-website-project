package com.example.database.api.form;

import lombok.Data;


@Data
public class CommentForm {
    private String content;

    private Long filmId;

    private Long userId;
}
