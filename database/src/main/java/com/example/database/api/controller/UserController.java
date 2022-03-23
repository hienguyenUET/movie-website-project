package com.example.database.api.controller;

import com.example.database.api.form.UserForm;
import com.example.database.api.response.ApiResponse;
import com.example.database.model.dto.UserDto;
import com.example.database.model.entity.User;
import com.example.database.repository.CommentRepository;
import com.example.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user/api")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse> addUser(@RequestBody UserForm data) {
        User user = userService.addNewUser(data);
        UserDto dto = user.toDto();
        ApiResponse response = ApiResponse.success(user, HttpStatus.OK.value(), "Thêm người dùng thành công");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getUserList() {
        List<User> users = userService.getUserList();
        List<UserDto> dto = users.stream().map(User::toDto).collect(Collectors.toList());
        ApiResponse response = ApiResponse.success(dto, HttpStatus.OK.value(), "Danh sách các người dùng");
        return ResponseEntity.ok(response);
    }

}
