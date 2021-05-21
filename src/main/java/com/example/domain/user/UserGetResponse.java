package com.example.domain.user;

import com.example.domain.ordergroup.OrderGroupGetResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserGetResponse {
    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;

    private boolean delete;

    private List<OrderGroupGetResponse> orderGroupGetResponseList;

    @Builder
    public UserGetResponse(Long id, String account, String password, String status, String email,
                           String phoneNumber, LocalDateTime createdAt, LocalDateTime updatedAt,
                           String createdBy, String updatedBy, boolean delete, List<OrderGroupGetResponse> orderGroupGetResponseList) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.status = status;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.delete = delete;
        this.orderGroupGetResponseList = orderGroupGetResponseList;
    }

    public static UserGetResponse of(User user) {
        return UserGetResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .status(user.getStatus())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .createdBy(user.getCreatedBy())
                .updatedBy(user.getUpdatedBy())
                .delete(user.isDeleted())
//                .orderGroupGetResponseList(user.getOrderGroupList().stream()
//                        .map(orderGroup -> OrderGroupGetResponse.of(orderGroup))
//                        .collect(Collectors.toList()))
                .build();
    }

    public void setOrderGroupGetResponseList(List<OrderGroupGetResponse> orderGroupGetResponseList) {
        this.orderGroupGetResponseList = orderGroupGetResponseList;
    }
}
