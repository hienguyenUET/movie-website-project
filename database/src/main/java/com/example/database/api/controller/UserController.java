package com.example.database.api.controller;

import com.example.database.pattern.LazyInitializedSingleton;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/info")
    public ResponseEntity<LazyInitializedSingleton> getUser() {
        return new ResponseEntity<>(LazyInitializedSingleton.getInstance(), HttpStatus.OK);
    }
}