package com.example.controller;

import com.example.domain.user.*;
import com.example.application.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public UserOrderGroupGetResponse orderGroupGetAll(@PathVariable Long id) {
        return userService.userOrderGroupGetAll(id);
    }
}
