package com.example.repository;

import com.example.domain.user.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id);

    User save(User user);
}
