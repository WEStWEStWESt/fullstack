package com.west.fullstack;

import lombok.Data;

@Data
public class SignupRequest {
    private String name;
    private String email;
    private String password;

    public static String getUserName() {
        return ;
    }
}
