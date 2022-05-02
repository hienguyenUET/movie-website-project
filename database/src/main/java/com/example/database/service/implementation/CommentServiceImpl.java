//package com.example.database.service.Impl;
//
//import com.example.database.api.form.CommentForm;
//import com.example.database.model.entity.Comment;
//import com.example.database.model.entity.Movie;
//import com.example.database.model.entity.Person;
//import com.example.database.repository.CommentRepository;
//import com.example.database.repository.FilmRepository;
//import com.example.database.repository.PersonRepository;
//import com.example.database.service.CommentService;
//import com.example.database.utils.exception.BadRequestException;
//import com.example.database.utils.exception.NotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ObjectUtils;
//import org.springframework.util.StringUtils;
//
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class CommentServiceImpl implements CommentService {
//    @Autowired
//    CommentRepository commentRepository;
//
//    @Autowired
//    PersonRepository personRepository;
//
//    @Autowired
//    FilmRepository filmRepository;
//
//    @Override
//    public Comment addNewComment(CommentForm commentForm) {
//        if(!StringUtils.hasText(commentForm.getContent())) {
//            String mess = "Invalid argument";
//            throw new BadRequestException(mess);
//        }
//
//        if(commentForm.getFilmId() == null || commentForm.getFilmId() == 0) {
//            String mess = "Invalid argument";
//            throw new BadRequestException(mess);
//        }
//
//        if(commentForm.getUserId() == null || commentForm.getUserId() == 0) {
//            String mess = "Invalid argument";
//            throw new BadRequestException(mess);
//        }
//
////        Comment comment = Comment.builder()
////                .content(commentForm.getContent())
////                .build();
////
////        Person person = personRepository.findById(commentForm.getUserId()).get();
////        comment.setPerson(person);
////
////        Movie movie = filmRepository.findById(commentForm.getFilmId()).get();
////        comment.setFilm(movie);
//
////        movie.getComments().add(comment);
////        return save(comment);
//    }
//
//    @Override
//    public Comment updateComment(Long id, String content) {
//        Comment comment = commentRepository.findById(id).get();
//        if(ObjectUtils.isEmpty(comment)) {
//            String mess = "comment-not-exits";
//            throw new NotFoundException(mess);
//        }
//        comment.setContent(content);
//
//        return save(comment);
//    }
//
//    @Override
//    public void deleteComment(Long id) {
//        Comment comment = commentRepository.findById(id).get();
//        if(ObjectUtils.isEmpty(comment)) {
//            String mess = "comment-not-exits";
//            throw new NotFoundException(mess);
//        }
//
//        commentRepository.deleteById(id);
//    }
//
//    @Override
//    public Comment getById(Long id) {
//        Comment comment = commentRepository.findById(id).get();
//        if(ObjectUtils.isEmpty(comment)) {
//            String mess = "comment-not-exits";
//            throw new NotFoundException(mess);
//        }
//
//        return comment;
//    }
//
//    @Override
//    public List<Comment> getCommentList() {
//        List<Comment> comments = (List<Comment>) commentRepository.findAll();
//        if(ObjectUtils.isEmpty(comments)) {
//            return Collections.EMPTY_LIST;
//        }
//
//        return comments;
//    }
//
//    @Override
//    public Comment save(Comment comment) {
//        return commentRepository.save(comment);
//    }
//}
