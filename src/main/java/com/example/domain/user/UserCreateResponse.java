package com.example.domain.user;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserCreateResponse {
    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    @Builder
    public UserCreateResponse(String account, String password, String status,
                              String email, String phoneNumber, LocalDateTime registeredAt,
                              LocalDateTime createdAt, String createdBy) {
        this.account = account;
        this.password = password;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registeredAt = registeredAt;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public static UserCreateResponse of(User user) {
        return UserCreateResponse.builder()
                .account(user.getAccount())
                .password(user.getPassword())
                .status(user.getStatus())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .registeredAt(user.getRegisteredAt())
                .createdAt(user.getCreatedAt())
                .createdBy(user.getCreatedBy())
                .build();
    }
}
