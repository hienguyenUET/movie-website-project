//package com.example.database.api.controller;
//
//import com.example.database.api.form.CommentForm;
//import com.example.database.api.response.ApiResponse;
//import com.example.database.model.dto.CommentDto;
//import com.example.database.model.entity.Comment;
//import com.example.database.service.CommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("comment/api")
//
//public class CommentController {
//    @Autowired
//    private CommentService commentService;
//
//    @PostMapping
//    public ResponseEntity<ApiResponse> addComment(@RequestBody CommentForm commentForm) {
//        Comment comment = commentService.addNewComment(commentForm);
//        CommentDto dto = comment.toDto();
//        ApiResponse response = ApiResponse.success(comment, HttpStatus.OK.value(), "Thêm bình luận thành công");
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping
//    public ResponseEntity<ApiResponse> getCommentList() {
//        List<Comment> users = commentService.getCommentList();
//        List<CommentDto> dto = users.stream().map(Comment::toDto).collect(Collectors.toList());
//        ApiResponse response = ApiResponse.success(dto, HttpStatus.OK.value(), "Danh sách các bình luận");
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ApiResponse> getCommentById(@PathVariable long id) {
//        Comment comment = commentService.getById(id);
//        CommentDto dto = comment.toDto();
//        ApiResponse response = ApiResponse.success(dto,HttpStatus.OK.value(), String.format("Người dùng %d",id));
//        return ResponseEntity.ok(response);
//    }
//
//    @PutMapping( "/{id}")
//    public ResponseEntity<ApiResponse> updateComment(@RequestBody CommentForm commentForm, @PathVariable("id") Long id) {
//        Comment comment = commentService.updateComment(id, commentForm.getContent());
//        CommentDto dto = comment.toDto();
//        ApiResponse response = ApiResponse.success(comment,HttpStatus.OK.value(), "Chỉnh sửa thành công bình luận: " + id);
//        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<ApiResponse> deleteComment(@PathVariable long id) {
//        commentService.deleteComment(id);
//        ApiResponse response = ApiResponse.success(null,HttpStatus.OK.value(), "Xóa thành công bình luận: " + id);
//        return ResponseEntity.ok(response);
//    }
//}
