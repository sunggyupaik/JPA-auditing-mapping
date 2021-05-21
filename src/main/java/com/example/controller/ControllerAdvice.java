package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.dto.Error;
import com.example.dto.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import errors.UserNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUserNotFound(UserNotFoundException e) {
        return ErrorResponse.withoutErrorFrom(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        List<Error> errorList = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            FieldError fieldError = (FieldError) error;
            String field = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            String invalidValue = fieldError.getRejectedValue().toString();
            Error errorMessage = Error.builder()
                    .field(field)
                    .message(message)
                    .invalidValue(invalidValue)
                    .build();
            
            errorList.add(errorMessage);
        });
        return ErrorResponse.withErrorFrom(HttpStatus.BAD_REQUEST.value(), errorList);
    }
}
