package com.west.fullstack;

import lombok.Data;

@Data
public class SigninRequest {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
