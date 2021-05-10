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

    //추후 @CreatedBy 사용하고 해당 필드 제거하기
    private String createdBy;

    @Builder
    public UserCreateRequest(String account, String password, String status, String email,
                             String phoneNumber, String createdBy) {
        this.account = account;
        this.password = password;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdBy = createdBy;
    }

    public User toEntity() {
        return User.builder()
                .account(this.account)
                .password(this.password)
                .status(this.status)
                .email(this.email)
                .phoneNumber(this.phoneNumber)
                .createdBy(this.createdBy)
                .build();
    }
}
