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
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String status;

    private String name;

    private String title;

    private String text;

    private BigDecimal price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;

    //Item 1 : N OrderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;

    //Item N : 1 Partner
    @ManyToOne
    private Partner partner;

    @Builder
    public Item(Long id, String status, String name, String title, String text,
                BigDecimal price, String brandName, LocalDateTime registeredAt,
                LocalDateTime unregisteredAt, LocalDateTime createdAt,
                LocalDateTime updatedAt, String createdBy, String updatedBy) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.title = title;
        this.text = text;
        this.price = price;
        this.brandName = brandName;
        this.registeredAt = registeredAt;
        this.unregisteredAt = unregisteredAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
