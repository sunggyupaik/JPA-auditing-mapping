package com.example.application;

import com.example.domain.user.*;
import com.example.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserGetResponse getUser(Long id) {
        return userRepository.findById(id)
                .map(UserGetResponse::of)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UserCreateResponse createUser(UserCreateRequest userCreateRequest) {
        User user = userCreateRequest.toEntity();
        User savedUser = userRepository.save(user);
        return UserCreateResponse.of(savedUser);
    }

    public UserUpdateResponse updateUser(Long id, UserUpdateRequest userUpdateRequest) {
        User user = findUser(id);
        user.changeFrom(userUpdateRequest);
        return UserUpdateResponse.of(user);
    }

    public User findUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UserGetResponse deleteUser(Long id) {
        User user = findUser(id);
        user.delete();
        return UserGetResponse.of(user);
    }
}
