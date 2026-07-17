package org.example.userpractice.controller;

import lombok.RequiredArgsConstructor;
import org.example.userpractice.dto.*;
import org.example.userpractice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserCreateResponse> create (
            @RequestBody UserCreateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(request));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserGetResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserGetResponse> getOne(
            @PathVariable Long userId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getOne(userId));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UserUpdateResponse> update(
            @PathVariable Long userId,
            @RequestBody UserUpdateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(userId, request));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<List<UserGetResponse>> delete(
            @PathVariable Long userId
    ) {
        userService.delete(userId);
        List<UserGetResponse> users = userService.getAll();

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
