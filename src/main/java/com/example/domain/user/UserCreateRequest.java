package com.example.domain.user;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserCreateRequest {
    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    @Builder
    public UserCreateRequest(String account, String password, String status,
                             String email, String phoneNumber) {
        this.account = account;
        this.password = password;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User toEntity() {
        return User.builder()
                .account(this.account)
                .password(this.password)
                .status(this.status)
                .email(this.email)
                .phoneNumber(this.phoneNumber)
                .build();
    }
}
