package com.example.database.service;

import com.example.database.api.form.CommentForm;
import com.example.database.model.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment addNewComment(CommentForm commentForm);

    Comment updateComment(Long id, String content);

    void deleteComment(Long id);

    Comment getById(Long id);

    List<Comment> getCommentList();

     Comment save(Comment comment);
}

