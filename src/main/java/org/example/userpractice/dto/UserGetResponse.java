package org.example.userpractice.dto;

import lombok.Getter;

@Getter
public class UserGetResponse {
    private final Long id;
    private final String title;
    private final String email;
    private final String address;

    public UserGetResponse(Long id, String title, String email, String address) {
        this.id = id;
        this.title = title;
        this.email = email;
        this.address = address;
    }
}
