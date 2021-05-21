package com.example.domain.adminuser;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class AdminUserCreateResponse {
    private String account;

    private String password;

    private String status;

    private String role;

    private String sleepTime;

    private LocalDateTime createdAt;
    @Builder
    public AdminUserCreateResponse(String account, String password, String status, String role,
                                   String sleepTime, LocalDateTime createdAt) {
        this.account = account;
        this.password = password;
        this.status = status;
        this.role = role;
        this.sleepTime = sleepTime;
        this.createdAt = createdAt;
    }

    public static AdminUserCreateResponse of(AdminUser adminUser) {
        return AdminUserCreateResponse.builder()
                .account(adminUser.getAccount())
                .password(adminUser.getPassword())
                .status(adminUser.getStatus())
                .role(adminUser.getRole())
                .sleepTime(adminUser.getSleepTime())
                .createdAt(adminUser.getCreatedAt())
                .build();
    }
}
