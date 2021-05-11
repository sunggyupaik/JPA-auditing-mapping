package com.example.domain.item;

import com.example.domain.BaseEntity;
import com.example.domain.orderdetail.OrderDetail;
import com.example.domain.Partner;
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
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"orderDetailList", "partner"})
public class Item extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String status;

    private String name;

    private String title;

    private String text;

    private BigDecimal price;

    private String brandName;

    //Item 1 : N OrderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;

    //Item N : 1 Partner
    @ManyToOne
    private Partner partner;

    @Builder
    public Item(Long id, String status, String name, String title,
                String text, BigDecimal price, String brandName) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.title = title;
        this.text = text;
        this.price = price;
        this.brandName = brandName;
    }
}
