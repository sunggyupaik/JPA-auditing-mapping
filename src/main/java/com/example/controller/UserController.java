package com.example.controller;

import com.example.application.UserService;
import com.example.domain.user.UserCreateRequest;
import com.example.domain.user.UserCreateResponse;
import com.example.domain.user.UserGetResponse;
import com.example.domain.user.UserOrderGroupGetResponse;
import com.example.domain.user.UserUpdateRequest;
import com.example.domain.user.UserUpdateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserGetResponse get(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public UserCreateResponse create(@RequestBody UserCreateRequest userCreateRequest) {
        return userService.createUser(userCreateRequest);
    }

    @PatchMapping("/{id}")
    public UserUpdateResponse update(
            @PathVariable Long id,
            @RequestBody UserUpdateRequest userUpdateRequest) {
        return userService.updateUser(id, userUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public UserGetResponse delete(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/{id}/order-group")
    public UserOrderGroupGetResponse orderGroupGetList(@PathVariable Long id) {
        return userService.userOrderGroupGetList(id);
    }

    @GetMapping("/{userId}/order-group/{orderGroupId}")
    public UserOrderGroupGetResponse orderGroupGet(@PathVariable Long userId,
                                                   @PathVariable Long orderGroupId) {
        return userService.userOrderGroupGet(userId, orderGroupId);
    }
}
