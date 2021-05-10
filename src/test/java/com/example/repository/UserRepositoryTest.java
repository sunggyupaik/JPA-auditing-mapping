package com.example.repository;

import com.example.AppTest;
import com.example.domain.user.User;
import com.example.domain.user.UserCreateRequest;
import com.example.infra.JpaUserRepository;
import org.junit.jupiter.api.Test;

import java.util.Random;

class UserRepositoryTest extends AppTest {
    private Random random;

    private JpaUserRepository jpaUserRepository;

    private static final String ACCOUNT = "account";
    private static final String PASSWORD = "password";
    private static final String STATUS = "created";
    private static final String EMAIL = "email";
    private static final String PHONE_NUMBER = "phoneNumber";

    UserRepositoryTest(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Test
    public void createUser() {
        random = new Random();

        for(int i=1; i<100; i++) {
            UserCreateRequest userCreateRequest = UserCreateRequest.builder()
                    .account(ACCOUNT + i)
                    .password(PASSWORD + i)
                    .status(STATUS + i)
                    .email(EMAIL + i)
                    .phoneNumber(PHONE_NUMBER + i)
                    .build();

            User user = userCreateRequest.toEntity();
            jpaUserRepository.save(user);
        }
    }
}
