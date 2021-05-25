package com.example.domain.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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

    @NotBlank(message = "도시는 필수값입니다")
    private String city;

    @NotBlank(message = "거리 주소는 필수값입니다")
    private String street;

    @NotBlank(message = "우편번호는 필수값입니다")
    private String zipcode;

    public UserCreateRequest(String account, String password, String status,
                             String email, String phoneNumber, String city, String street, String zipcode) {
        this.account = account;
        this.password = password;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
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
