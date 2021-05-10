package com.example.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserUpdateRequest {
    private String password;

    private String status;

    private String email;

    private String phoneNumber;


    public UserUpdateRequest(String password, String status, String email, String phoneNumber) {
        this.password = password;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User toEntity() {
        return User.builder()
                .password(this.password)
                .status(this.status)
                .email(this.email)
                .phoneNumber(this.phoneNumber)
                .build();
    }
}
