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
    public ResponseEntity<ApiResponse> addUser(@RequestBody UserForm userForm) {
        User user = userService.addNewUser(userForm);
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

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable long id) {
        User user = userService.getById(id);
        UserDto dto = user.toDto();
        ApiResponse response = ApiResponse.success(dto,HttpStatus.OK.value(), String.format("Người dùng %d",id));
        return ResponseEntity.ok(response);
    }

    @PutMapping( "/{id}")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody UserForm userForm, @PathVariable("id") Long id) {
        User user = userService.updateUser(id, userForm.getPassword(), userForm.getFilmId());
        UserDto dto = user.toDto();
        ApiResponse response = ApiResponse.success(user,HttpStatus.OK.value(), "Chỉnh sửa thành công người dùng: " + userForm.getName());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        ApiResponse response = ApiResponse.success(null,HttpStatus.OK.value(), "Xóa thành công người dùng: " + id);
        return ResponseEntity.ok(response);
    }
}
