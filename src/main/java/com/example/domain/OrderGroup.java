package com.example.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderGroup {
    @Id
    @GeneratedValue
    private Long id;

    private String status;

    private String orderType;

    private String revAddress;

    private String reName;

    private String paymentType;

    private BigDecimal totalPrice;

    private int totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;

    //OrderGroup N : 1 User
    @ManyToOne
    private User user;

    //OrderGroup 1 : N OrderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;

    @Builder
    public OrderGroup(Long id, String status, String orderType, String revAddress,
                      String reName, String paymentType, BigDecimal totalPrice,
                      int totalQuantity, LocalDateTime orderAt, LocalDateTime arrivalDate,
                      LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
        this.id = id;
        this.status = status;
        this.orderType = orderType;
        this.revAddress = revAddress;
        this.reName = reName;
        this.paymentType = paymentType;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.orderAt = orderAt;
        this.arrivalDate = arrivalDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
