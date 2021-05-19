package com.example.application;

import com.example.domain.item.Item;
import com.example.domain.item.ItemGetResponse;
import com.example.domain.ordergroup.OrderGroup;
import com.example.domain.ordergroup.OrderGroupGetResponse;
import com.example.domain.user.*;
import com.example.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
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

    public UserOrderGroupGetResponse userOrderGroupGetAll(Long id) {
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
                            .map(orderDetail -> orderDetail.getItem())
                            .map(item -> ItemGetResponse.of(item))
                            .collect(Collectors.toList());

                    orderGroupGetResponse.setItemGetResponseList(itemGetResponseList);
                    return orderGroupGetResponse;
                })
                .collect(Collectors.toList());

        userGetResponse.setOrderGroupGetResponseList(orderGroupGetResponseList);

        return UserOrderGroupGetResponse.of(userGetResponse);
    }
}
