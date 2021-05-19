package com.example.repository;

import com.example.domain.user.User;
import com.example.domain.user.UserCreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    private static final String ACCOUNT = "account";
    private static final String PASSWORD = "password";
    private static final String STATUS = "created";
    private static final String EMAIL = "email";
    private static final String PHONE_NUMBER = "phoneNumber";

    @Test
    public void createUser() {
        UserCreateRequest userCreateRequest = UserCreateRequest.builder()
                .account(ACCOUNT)
                .password(PASSWORD)
                .status(STATUS)
                .email(EMAIL)
                .phoneNumber(PHONE_NUMBER)
                .build();

        User user = userCreateRequest.toEntity();
        User savedUser = userRepository.save(user);

        assertAll(
                () -> assertThat(savedUser.getAccount()).isEqualTo(ACCOUNT),
                () -> assertThat(savedUser.getPassword()).isEqualTo(PASSWORD),
                () -> assertThat(savedUser.getStatus()).isEqualTo(STATUS),
                () -> assertThat(savedUser.getEmail()).isEqualTo(EMAIL),
                () -> assertThat(savedUser.getPhoneNumber()).isEqualTo(PHONE_NUMBER)
        );
    }
}
