package com.example.infra;

import com.example.domain.adminuser.AdminUser;
import com.example.repository.AdminUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAdminUserRepository
        extends AdminUserRepository, JpaRepository<AdminUser, Long> {
    AdminUser save(AdminUser adminUser);
}
