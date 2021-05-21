package com.example.domain.adminuser;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
@ToString
@Builder
public class AdminUser {
    @Id
    @GeneratedValue
    private Long id;

    private String account;

    private String password;

    @Builder.Default
    private String status = "REGISTERED";

    private String role;

    private LocalDateTime lastLoginAt;

    private LocalDateTime passwordUpdatedAt;

    @Builder.Default
    private int loginFailCount = 0;

    private String sleepTime;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public AdminUser(Long id, String account, String password, String status,
                     String role, LocalDateTime lastLoginAt, LocalDateTime passwordUpdatedAt,
                     int loginFailCount, String sleepTime, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.status = status;
        this.role = role;
        this.lastLoginAt = lastLoginAt;
        this.passwordUpdatedAt = passwordUpdatedAt;
        this.loginFailCount = loginFailCount;
        this.sleepTime = sleepTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
