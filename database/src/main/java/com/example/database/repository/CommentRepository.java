package com.example.database.repository;

import com.example.database.model.entity.Comment;
import com.example.database.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
