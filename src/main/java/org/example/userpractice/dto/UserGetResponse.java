package org.example.userpractice.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserGetResponse {
    private final Long id;
    private final String title;
    private final String email;
    private final String address;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public UserGetResponse(Long id, String title, String email, String address, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.email = email;
        this.address = address;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
