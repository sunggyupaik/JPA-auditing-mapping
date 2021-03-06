package com.example.domain.item;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ItemCreateRequest {
    private String status;

    private String name;

    private String title;

    private String text;

    private BigDecimal price;

    private String brandName;

    @Builder
    public ItemCreateRequest(String status, String name, String title,
                             String text, BigDecimal price, String brandName) {
        this.status = status;
        this.name = name;
        this.title = title;
        this.text = text;
        this.price = price;
        this.brandName = brandName;
    }

    public Item toEntity() {
        return Item.builder()
                .status(this.status)
                .name(this.name)
                .title(this.title)
                .text(this.text)
                .price(this.price)
                .brandName(this.brandName)
                .build();
    }
}
