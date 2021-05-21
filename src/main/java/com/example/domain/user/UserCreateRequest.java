package com.example.domain.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Builder
public class UserCreateRequest {
    @Builder.Default
    private String account = "";

    @Builder.Default
    @Size(min=3, max=10, message = "길이는 3~10 이어야 합니다.")
    private String password = "";

    @Builder.Default
    private String status = "";

    @Email(message = "이메일 형식을 맞춰야 합니다.")
    private String email;

    @Builder.Default
    private String phoneNumber = "";

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
