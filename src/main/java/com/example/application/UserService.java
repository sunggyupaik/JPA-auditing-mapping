package com.example.application;

import com.example.domain.item.ItemGetResponse;
import com.example.domain.orderdetail.OrderDetail;
import com.example.domain.ordergroup.OrderGroup;
import com.example.domain.ordergroup.OrderGroupGetResponse;
import com.example.domain.user.User;
import com.example.domain.user.UserCreateRequest;
import com.example.domain.user.UserCreateResponse;
import com.example.domain.user.UserGetResponse;
import com.example.domain.user.UserOrderGroupGetResponse;
import com.example.domain.user.UserUpdateRequest;
import com.example.domain.user.UserUpdateResponse;
import com.example.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserGetResponse getUser(Long id) {
        return userRepository.findById(id)
                .map(UserGetResponse::of)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UserCreateResponse createUser(UserCreateRequest userCreateRequest) {
        User user = userCreateRequest.toEntity();
        User savedUser = userRepository.save(user);
        return UserCreateResponse.of(savedUser);
    }

    public UserUpdateResponse updateUser(Long id, UserUpdateRequest userUpdateRequest) {
        User user = findUser(id);
        user.changeFrom(userUpdateRequest);
        return UserUpdateResponse.of(user);
    }

    public User findUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UserGetResponse deleteUser(Long id) {
        User user = findUser(id);
        user.delete();
        return UserGetResponse.of(user);
    }

    public UserOrderGroupGetResponse userOrderGroupGetList(Long id) {
        //User
        User user = findUser(id);
        UserGetResponse userGetResponse = UserGetResponse.of(user);

        //OrderGroup
        List<OrderGroup> orderGroupList = user.getOrderGroupList();
        List<OrderGroupGetResponse> orderGroupGetResponseList = orderGroupList.stream()
                .map(orderGroup -> {
                    OrderGroupGetResponse orderGroupGetResponse = OrderGroupGetResponse.of(orderGroup);

                    //Item
                    List<ItemGetResponse> itemGetResponseList = orderGroup.getOrderDetailList().stream()
                            .map(OrderDetail::getItem)
                            .map(ItemGetResponse::of)
                            .collect(Collectors.toList());

                    orderGroupGetResponse.setItemGetResponseList(itemGetResponseList);
                    return orderGroupGetResponse;
                })
                .collect(Collectors.toList());

        userGetResponse.setOrderGroupGetResponseList(orderGroupGetResponseList);

        return UserOrderGroupGetResponse.of(userGetResponse);
    }

    public UserOrderGroupGetResponse userOrderGroupGet(Long userId, Long orderGroupId) {
        //User
        User user = findUser(userId);
        UserGetResponse userGetResponse = UserGetResponse.of(user);

        //OrderGroup
        List<OrderGroup> orderGroupList = user.getOrderGroupList();
        OrderGroupGetResponse orderGroupGetResponse = orderGroupList.stream()
                .filter(orderGp -> orderGp.getId().equals(orderGroupId))
                .findFirst()
                .map(orderGpOne -> {
                    OrderGroupGetResponse orderGroupGetResponseOne = OrderGroupGetResponse.of(orderGpOne);

                    //Item
                    List<ItemGetResponse> itemGetResponseList = orderGpOne.getOrderDetailList().stream()
                            .map(OrderDetail::getItem)
                            .map(ItemGetResponse::of)
                            .collect(Collectors.toList());

                    orderGroupGetResponseOne.setItemGetResponseList(itemGetResponseList);
                    return orderGroupGetResponseOne;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        List<OrderGroupGetResponse> list = new ArrayList<>();
        list.add(orderGroupGetResponse);
        userGetResponse.setOrderGroupGetResponseList(list);

        return UserOrderGroupGetResponse.of(userGetResponse);
    }
}
