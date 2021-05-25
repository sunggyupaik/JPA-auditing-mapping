package com.example.domain.ordergroup;

import com.example.domain.BaseEntity;
import com.example.domain.Delivery;
import com.example.domain.orderdetail.OrderDetail;
import com.example.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"user", "orderDetailList"})
public class OrderGroup extends BaseEntity {
    @Id
    @GeneratedValue
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

    //Delivery 1 : 1 OrderGroup
    @OneToOne
    private Delivery delivery;

    //OrderGroup N : 1 User
    @ManyToOne
    private User user;

    //OrderGroup 1 : N OrderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;

    @Builder
    public OrderGroup(Long id, String status, String orderType, String revAddress,
                      String revName, String paymentType, BigDecimal totalPrice, int totalQuantity, LocalDateTime orderAt, 
                      LocalDateTime arrivalDate, Delivery delivery, User user, List<OrderDetail> orderDetailList) {
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
        this.delivery = delivery;
        this.user = user;
        this.orderDetailList = orderDetailList;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
