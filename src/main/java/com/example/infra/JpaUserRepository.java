package com.example.infra;

import com.example.domain.User;
import com.example.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository
        extends UserRepository, JpaRepository<User, Long> {
    User save(User user);
}
