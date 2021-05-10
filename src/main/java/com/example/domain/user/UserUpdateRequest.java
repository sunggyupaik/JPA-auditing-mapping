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

    //추후 @UpdatedBy 사용하고 해당 필드 제거하기
    private String updatedBy;

    public UserUpdateRequest(String password, String status, String email,
                             String phoneNumber, String updatedBy) {
        this.password = password;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.updatedBy = updatedBy;
    }

    public User toEntity() {
        return User.builder()
                .password(this.password)
                .status(this.status)
                .email(this.email)
                .phoneNumber(this.phoneNumber)
                .updatedBy(this.updatedBy)
                .build();
    }
}
