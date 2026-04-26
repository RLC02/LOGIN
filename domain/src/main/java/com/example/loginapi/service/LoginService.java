package com.example.loginapi.service;

import com.example.loginapi.model.Login;
import com.example.loginapi.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository repository;

    public List<Login> findAll() {
        return repository.findAll();
    }

    public Optional<Login> findById(String id) {
        return repository.findById(id);
    }

    public Login save(Login login) {
        return repository.save(login);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Optional<Login> update(String id, Login loginData) {
        return repository.findById(id).map(existing -> {
            existing.setUsername(loginData.getUsername());
            existing.setPassword(loginData.getPassword());
            existing.setRoles(loginData.getRoles());
            return repository.save(existing);
        });
    }
}
