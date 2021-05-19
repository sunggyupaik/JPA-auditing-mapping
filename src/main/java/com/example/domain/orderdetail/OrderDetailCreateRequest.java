package com.example.domain.orderdetail;

import com.example.domain.item.Item;
import com.example.domain.ordergroup.OrderGroup;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class OrderDetailCreateRequest {
    private String status;

    private LocalDateTime arrivalDate;

    private int quantity;

    private BigDecimal totalPrice;

    private OrderGroup orderGroup;

    private Item item;

    @Builder
    public OrderDetailCreateRequest(String status, LocalDateTime arrivalDate, int quantity,
                                    BigDecimal totalPrice, OrderGroup orderGroup, Item item) {
        this.status = status;
        this.arrivalDate = arrivalDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderGroup = orderGroup;
        this.item = item;
    }

    public OrderDetail toEntity() {
        return OrderDetail.builder()
                .status(this.status)
                .arrivalDate(this.arrivalDate)
                .quantity(this.quantity)
                .totalPrice(this.totalPrice)
                .orderGroup(this.orderGroup)
                .item(this.item)
                .build();
    }
}
