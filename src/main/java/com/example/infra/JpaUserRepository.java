package com.example.infra;

import com.example.domain.user.User;
import com.example.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaUserRepository
        extends UserRepository, JpaRepository<User, Long> {
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    void deleteAll();
}
