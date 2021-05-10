package com.example.infra;

import com.example.domain.OrderGroup;
import com.example.repository.OrderGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderGroupRepository
        extends OrderGroupRepository, JpaRepository<OrderGroup, Long> {
    OrderGroup save(OrderGroup orderGroup);
}
