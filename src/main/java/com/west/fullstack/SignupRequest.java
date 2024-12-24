package com.west.fullstack;

import lombok.Data;
import lombok.Getter;

@Data
public class SignupRequest {

    private String username;
    private String email;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
