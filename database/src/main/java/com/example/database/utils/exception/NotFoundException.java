package com.example.database.utils.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{


    public String message;

    public NotFoundException(String message) {
        this.message = message;
    }
}
