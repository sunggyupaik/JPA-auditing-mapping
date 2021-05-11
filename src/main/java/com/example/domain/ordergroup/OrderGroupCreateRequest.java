package com.example.domain.ordergroup;

import com.example.domain.orderdetail.OrderDetail;
import com.example.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"user", "orderDetailList"})
public class OrderGroupCreateRequest {
    private String status;

    private String orderType;

    private String revAddress;

    private String revName;

    private String paymentType;

    private BigDecimal totalPrice;

    private int totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    private User user;

    private List<OrderDetail> orderDetailList;

    @Builder
    public OrderGroupCreateRequest(String status, String orderType, String revAddress,
                                   String revName, String paymentType, BigDecimal totalPrice,
                                   int totalQuantity, LocalDateTime orderAt, LocalDateTime arrivalDate,
                                   User user, List<OrderDetail> orderDetailList) {
        this.status = status;
        this.orderType = orderType;
        this.revAddress = revAddress;
        this.revName = revName;
        this.paymentType = paymentType;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.orderAt = orderAt;
        this.arrivalDate = arrivalDate;
        this.user = user;
        this.orderDetailList = orderDetailList;
    }

    public OrderGroup toEntity() {
        return OrderGroup.builder()
                .status(this.status)
                .orderType(this.orderType)
                .revAddress(this.revAddress)
                .revName(this.revName)
                .paymentType(this.paymentType)
                .totalPrice(this.totalPrice)
                .totalQuantity(this.totalQuantity)
                .orderAt(this.orderAt)
                .arrivalDate(this.arrivalDate)
                .user(this.user)
                .orderDetailList(this.orderDetailList)
                .build();
    }
}
