package com.example.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {
    private int statusCode;
    private String message;
    List<Error> errorList;
 
    @Builder
    public ErrorResponse(int statusCode, String message, List<Error> errorList) {
        this.statusCode = statusCode;
        this.message = message;
        this.errorList = errorList;
    }

    public static ErrorResponse withoutErrorFrom(int statusCode, String message) {
        return ErrorResponse.builder()
            .statusCode(statusCode)
            .message(message)
            .errorList(new ArrayList<>())
            .build();
    }

    public static ErrorResponse withErrorFrom(int statusCode, List<Error> errorList) {
        return ErrorResponse.builder()
            .statusCode(statusCode)
            .message("")
            .errorList(errorList)
            .build();
    }
}
