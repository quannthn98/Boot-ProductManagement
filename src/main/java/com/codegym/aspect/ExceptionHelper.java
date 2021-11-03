package com.codegym.aspect;

import com.codegym.Exception.DuplicateException;
import com.codegym.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class ExceptionHelper {
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<User> isDuplicated(){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
