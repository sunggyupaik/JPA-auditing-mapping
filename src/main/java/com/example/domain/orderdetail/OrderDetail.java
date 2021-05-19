package com.example.domain.orderdetail;

import com.example.domain.BaseEntity;
import com.example.domain.item.Item;
import com.example.domain.ordergroup.OrderGroup;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"orderGroup", "item"})
public class OrderDetail extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private int quantity;

    private BigDecimal totalPrice;

    //OrderDetail N : 1 OrderGroup
    @ManyToOne
    private OrderGroup orderGroup;

    //OrderDetail N : 1 Item
    @ManyToOne
    private Item item;

    @Builder
    public OrderDetail(Long id, String status, LocalDateTime arrivalDate, int quantity,
                       BigDecimal totalPrice, OrderGroup orderGroup, Item item) {
        this.id = id;
        this.status = status;
        this.arrivalDate = arrivalDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderGroup = orderGroup;
        this.item = item;
    }

    public void setOrderGroup(OrderGroup orderGroup) {
        this.orderGroup = orderGroup;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
