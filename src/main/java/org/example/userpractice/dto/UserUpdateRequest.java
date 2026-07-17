package org.example.userpractice.dto;

import lombok.Getter;

@Getter
public class UserUpdateRequest {

    private String name;
    private String email;
    private String address;
}
