package com.example.repository;

import com.example.domain.User;

public interface UserRepository {
    User save(User user);
}
