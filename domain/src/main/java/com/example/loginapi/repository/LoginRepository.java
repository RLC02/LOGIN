package com.example.loginapi.repository;

import com.example.loginapi.model.Login;
import java.util.List;
import java.util.Optional;

public interface LoginRepository {
    List<Login> findAll();
    Optional<Login> findById(String id);
    Login save(Login login);
    void deleteById(String id);
}
