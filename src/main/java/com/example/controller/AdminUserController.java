package com.example.controller;

import com.example.application.AdminUserService;
import com.example.domain.adminuser.AdminUserCreateRequest;
import com.example.domain.adminuser.AdminUserCreateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin-user")
public class AdminUserController {
    private final AdminUserService adminUserService;

    public AdminUserController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminUserCreateResponse create(@RequestBody @Valid AdminUserCreateRequest adminUserCreateRequest) {
        return adminUserService.createAdminUser(adminUserCreateRequest);
    }
}
