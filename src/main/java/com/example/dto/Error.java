package com.example.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Error {
    private String field;
    private String message;
    private String invalidValue;

    @Builder
    public Error(String field, String message, String invalidValue) {
        this.field = field;
        this.message = message;
        this.invalidValue = invalidValue;
    }
}
