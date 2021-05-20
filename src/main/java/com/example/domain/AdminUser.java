package com.example.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class AdminUser {
    @Id
    @GeneratedValue
    private Long id;

    private String account;

    private String password;

    private String status;

    private String role;

    private LocalDateTime lastLoginAt;

    private LocalDateTime passwordUpdatedAt;

    private int login_fail_count;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String updatedBy;

    @Builder
    public AdminUser(Long id, String account, String password, String status,
                     String role, LocalDateTime lastLoginAt, LocalDateTime passwordUpdatedAt,
                     int login_fail_count, LocalDateTime registeredAt, LocalDateTime unregisteredAt,
                     LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.status = status;
        this.role = role;
        this.lastLoginAt = lastLoginAt;
        this.passwordUpdatedAt = passwordUpdatedAt;
        this.login_fail_count = login_fail_count;
        this.registeredAt = registeredAt;
        this.unregisteredAt = unregisteredAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
