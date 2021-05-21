package com.example.repository;

import com.example.domain.ordergroup.OrderGroup;

public interface OrderGroupRepository {
    OrderGroup save(OrderGroup orderGroup);

    void deleteAll();
}
