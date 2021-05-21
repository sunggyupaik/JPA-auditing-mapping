package com.example.domain.ordergroup;

import com.example.domain.item.ItemGetResponse;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class OrderGroupGetResponse {
    private Long id;

    private String status;

    private String orderType;

    private String revAddress;

    private String revName;

    private String paymentType;

    private BigDecimal totalPrice;

    private int totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;

    private List<ItemGetResponse> itemGetResponseList;

    @Builder
    public OrderGroupGetResponse(Long id, String status, String orderType, String revAddress, String revName,
                                 String paymentType, BigDecimal totalPrice, int totalQuantity, LocalDateTime orderAt,
                                 LocalDateTime arrivalDate, LocalDateTime createdAt, LocalDateTime updatedAt,
                                 String createdBy, String updatedBy, List<ItemGetResponse> itemGetResponseList) {
        this.id = id;
        this.status = status;
        this.orderType = orderType;
        this.revAddress = revAddress;
        this.revName = revName;
        this.paymentType = paymentType;
        this.totalPrice = totalPrice;
        this.totalQuantity = totalQuantity;
        this.orderAt = orderAt;
        this.arrivalDate = arrivalDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.itemGetResponseList = itemGetResponseList;
    }

    public static OrderGroupGetResponse of(OrderGroup orderGroup) {
        return OrderGroupGetResponse.builder()
                .id(orderGroup.getId())
                .status(orderGroup.getStatus())
                .orderType(orderGroup.getOrderType())
                .revAddress(orderGroup.getRevAddress())
                .revName(orderGroup.getRevName())
                .paymentType(orderGroup.getPaymentType())
                .totalPrice(orderGroup.getTotalPrice())
                .totalQuantity(orderGroup.getTotalQuantity())
                .orderAt(orderGroup.getOrderAt())
                .arrivalDate(orderGroup.getArrivalDate())
                .createdAt(orderGroup.getCreatedAt())
                .updatedAt(orderGroup.getUpdatedAt())
                .createdBy(orderGroup.getCreatedBy())
                .updatedBy(orderGroup.getUpdatedBy())
                .build();
    }

    public void setItemGetResponseList(List<ItemGetResponse> itemGetResponseList) {
        this.itemGetResponseList = itemGetResponseList;
    }
}
