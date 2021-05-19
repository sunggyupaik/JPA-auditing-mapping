package com.example.domain.orderdetail;

import com.example.domain.item.ItemGetResponse;
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
public class OrderDetailGetResponse {
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private int quantity;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;

    private ItemGetResponse itemGetResponse;

    @Builder
    public OrderDetailGetResponse(Long id, String status, LocalDateTime arrivalDate, int quantity,
                                  BigDecimal totalPrice, LocalDateTime createdAt, LocalDateTime updatedAt,
                                  String createdBy, String updatedBy, ItemGetResponse itemGetResponse) {
        this.id = id;
        this.status = status;
        this.arrivalDate = arrivalDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.itemGetResponse = itemGetResponse;
    }

    public static OrderDetailGetResponse of(OrderDetail orderDetail) {
        return OrderDetailGetResponse.builder()
                .id(orderDetail.getId())
                .status(orderDetail.getStatus())
                .arrivalDate(orderDetail.getArrivalDate())
                .quantity(orderDetail.getQuantity())
                .totalPrice(orderDetail.getTotalPrice())
                .createdAt(orderDetail.getCreatedAt())
                .updatedAt(orderDetail.getUpdatedAt())
                .createdBy(orderDetail.getCreatedBy())
                .updatedBy(orderDetail.getUpdatedBy())
                //item 설정
                .build();
    }

    public void setItem(ItemGetResponse itemGetResponse) {
        this.itemGetResponse = itemGetResponse;
    }
}
