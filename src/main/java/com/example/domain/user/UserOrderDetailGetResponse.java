package com.example.domain.user;

import com.example.domain.orderdetail.OrderDetailGetResponse;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserOrderDetailGetResponse {
    private List<OrderDetailGetResponse> orderDetailGetResponseList;

    @Builder
    public UserOrderDetailGetResponse(List<OrderDetailGetResponse> orderDetailGetResponseList) {
        this.orderDetailGetResponseList = orderDetailGetResponseList;
    }

    public static UserOrderDetailGetResponse from(List<OrderDetailGetResponse> orderDetailGetResponseList) {
        return UserOrderDetailGetResponse.builder()
                .orderDetailGetResponseList(orderDetailGetResponseList)
                .build();
    }
}
