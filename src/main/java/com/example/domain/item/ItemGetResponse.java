package com.example.domain.item;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ItemGetResponse {
    private Long id;

    private String status;

    private String name;

    private String title;

    private String text;

    private BigDecimal price;

    private String brandName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;

    @Builder
    public ItemGetResponse(Long id, String status, String name, String title, String text,
                           BigDecimal price, String brandName, LocalDateTime createdAt,
                           LocalDateTime updatedAt, String createdBy, String updatedBy) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.title = title;
        this.text = text;
        this.price = price;
        this.brandName = brandName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public static ItemGetResponse of(Item item) {
        return ItemGetResponse.builder()
                .id(item.getId())
                .status(item.getStatus())
                .name(item.getName())
                .title(item.getTitle())
                .text(item.getText())
                .price(item.getPrice())
                .brandName(item.getBrandName())
                .createdAt(item.getCreatedAt())
                .createdBy(item.getCreatedBy())
                .updatedAt(item.getUpdatedAt())
                .updatedBy(item.getUpdatedBy())
                .build();
    }
}
