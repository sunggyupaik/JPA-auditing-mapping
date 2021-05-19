package com.example.repository;

import com.example.domain.orderdetail.OrderDetail;

public interface OrderDetailRepository {
    OrderDetail save(OrderDetail orderDetail);

    void deleteAll();
}
