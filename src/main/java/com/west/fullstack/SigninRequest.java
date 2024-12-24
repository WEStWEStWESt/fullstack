package com.west.fullstack;

import lombok.Data;
import lombok.Getter;

@Data
public class SigninRequest {

    @Getter
    private String username;
    @Getter
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
