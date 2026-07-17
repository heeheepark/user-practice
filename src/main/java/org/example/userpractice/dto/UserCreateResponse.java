package org.example.userpractice.dto;

import lombok.Getter;

@Getter
public class UserCreateResponse {

    private final Long id;
    private final String name;
    private final String email;
    private final String address;

    public UserCreateResponse(Long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
