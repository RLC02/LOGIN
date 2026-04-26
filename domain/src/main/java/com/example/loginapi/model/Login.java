package com.example.loginapi.model;

import lombok.Data;
import java.util.List;

@Data
public class Login {
    private String id;
    private String username;
    private String password;
    private List<String> roles;
}
