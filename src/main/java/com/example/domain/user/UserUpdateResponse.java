package com.example.domain.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserUpdateResponse {
    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime updatedAt;

    private String updatedBy;

    @Builder
    public UserUpdateResponse(String password, String status, String email, String phoneNumber,
                              LocalDateTime updatedAt, String updatedBy) {
        this.password = password;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public static UserUpdateResponse of(User updatedUser) {
        return UserUpdateResponse.builder()
                .password(updatedUser.getPassword())
                .status(updatedUser.getStatus())
                .email(updatedUser.getEmail())
                .phoneNumber(updatedUser.getPhoneNumber())
                .updatedAt(updatedUser.getUpdatedAt())
                .updatedBy(updatedUser.getUpdatedBy())
                .build();
    }
}
