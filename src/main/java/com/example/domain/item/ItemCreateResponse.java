package com.example.domain.item;

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
public class ItemCreateResponse {
    private String status;

    private String name;

    private String title;

    private String text;

    private BigDecimal price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    @Builder
    public ItemCreateResponse(String status, String name, String title, String text,
                              BigDecimal price, String brandName, LocalDateTime registeredAt,
                              LocalDateTime createdAt, String createdBy) {
        this.status = status;
        this.name = name;
        this.title = title;
        this.text = text;
        this.price = price;
        this.brandName = brandName;
        this.registeredAt = registeredAt;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public static ItemCreateResponse of(Item item) {
        return ItemCreateResponse.builder()
                .status(item.getStatus())
                .name(item.getName())
                .title(item.getTitle())
                .text(item.getText())
                .price(item.getPrice())
                .brandName(item.getBrandName())
                .registeredAt(item.getRegisteredAt())
                .createdAt(item.getCreatedAt())
                .createdBy(item.getCreatedBy())
                .build();
    }
}
