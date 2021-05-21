package com.example.application;

import com.example.domain.adminuser.AdminUser;
import com.example.domain.adminuser.AdminUserCreateRequest;
import com.example.domain.adminuser.AdminUserCreateResponse;
import com.example.repository.AdminUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService {
    private final AdminUserRepository adminUserRepository;

    public AdminUserService(AdminUserRepository adminUserRepository) {
        this.adminUserRepository = adminUserRepository;
    }

    public AdminUserCreateResponse createAdminUser(AdminUserCreateRequest adminUserCreateRequest) {
        AdminUser adminUser = adminUserCreateRequest.toEntity();
        AdminUser savedAdminUser = adminUserRepository.save(adminUser);
        return AdminUserCreateResponse.of(savedAdminUser);
    }
}
