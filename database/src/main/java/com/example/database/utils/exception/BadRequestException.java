package com.example.database.utils.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{


    public String message;

    public BadRequestException(String message) {
        this.message = message;
    }
}
