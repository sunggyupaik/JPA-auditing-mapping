package com.example.domain.user;

import lombok.*;

import java.time.LocalDateTime;

import com.example.domain.Address;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserCreateResponse {
    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private Address address;

    @Builder
    public UserCreateResponse(String account, String password, String status,
                              String email, String phoneNumber,
                              LocalDateTime createdAt, String createdBy, Address address) {
        this.account = account;
        this.password = password;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.address = address;
    }

    public static UserCreateResponse of(User user) {
        return UserCreateResponse.builder()
                .account(user.getAccount())
                .password(user.getPassword())
                .status(user.getStatus())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .createdBy(user.getCreatedBy())
                .address(user.getAddress())
                .build();
    }
}
