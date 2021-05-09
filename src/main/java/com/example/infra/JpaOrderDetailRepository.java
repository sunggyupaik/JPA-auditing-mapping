package com.example.infra;

import com.example.domain.OrderDetail;
import com.example.repository.OrderDetailRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderDetailRepository
        extends OrderDetailRepository, JpaRepository<OrderDetail, Long> {
    OrderDetail save(OrderDetail orderDetail);
}
