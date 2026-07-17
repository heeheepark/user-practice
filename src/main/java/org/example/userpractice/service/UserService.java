package org.example.userpractice.service;

import lombok.RequiredArgsConstructor;
import org.example.userpractice.dto.*;
import org.example.userpractice.entity.User;
import org.example.userpractice.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    @Transactional
    public UserCreateResponse save(UserCreateRequest request) {
        User user = new User(request.getName(), request.getEmail(), request.getAddress());
        User saveUser = userRepository.save(user);
        return new UserCreateResponse(saveUser.getId(), saveUser.getName(), saveUser.getEmail(), saveUser.getAddress(), saveUser.getCreatedAt(), saveUser.getModifiedAt());
    }

    @Transactional(readOnly = true)
    public List<UserGetResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<UserGetResponse> dtos = new ArrayList<>();

        for (User user : users) {
            dtos.add(new UserGetResponse(user.getId(), user.getName(), user.getEmail(), user.getAddress(), user.getCreatedAt(), user.getModifiedAt()));
        }

        return dtos;
    }

    @Transactional(readOnly = true)
    public UserGetResponse getOne(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 없습니다.")
        );

        return new UserGetResponse(user.getId(), user.getName(), user.getEmail(), user.getAddress(), user.getCreatedAt(), user.getModifiedAt());
    }

    @Transactional
    public UserUpdateResponse update(Long userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당 유저가 없습니다.")
        );

        user.updateUser(request.getName(), request.getEmail(), request.getAddress());

        return new UserUpdateResponse(user.getId(), user.getName(), user.getEmail(), user.getAddress(), user.getCreatedAt(), user.getModifiedAt());
    }

    @Transactional
    public void delete(Long userId) {
        boolean exist = userRepository.existsById(userId);
        if (!exist) {
            throw new IllegalArgumentException("해당 유저가 없습니다.");
        }

        userRepository.deleteById(userId);
    }
}
