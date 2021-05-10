package com.example.domain.user;

import com.example.domain.OrderGroup;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"orderGroupList"})
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    @CreatedDate
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

    private boolean deleted = false;

    //User 1 : N orderGroup
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    List<OrderGroup> orderGroupList = new ArrayList<>();

    @Builder
    public User(Long id, String account, String password, String status,
                String email, String phoneNumber, LocalDateTime registeredAt,
                LocalDateTime unregisteredAt, LocalDateTime createdAt,
                LocalDateTime updatedAt, String createdBy, String updatedBy, boolean deleted) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registeredAt = registeredAt;
        this.unregisteredAt = unregisteredAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.deleted = deleted;
    }

    public void changeFrom(UserUpdateRequest userUpdateRequest) {
        this.password = userUpdateRequest.getPassword();
        this.status = userUpdateRequest.getStatus();
        this.email = userUpdateRequest.getEmail();
        this.phoneNumber = userUpdateRequest.getPhoneNumber();
    }

    public void delete() {
        this.deleted = true;
        this.unregisteredAt = LocalDateTime.now();
    }
}
