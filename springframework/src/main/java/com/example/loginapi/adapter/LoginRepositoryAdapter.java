package com.example.loginapi.adapter;

import com.example.loginapi.entity.LoginEntity;
import com.example.loginapi.model.Login;
import com.example.loginapi.repository.LoginMongoRepository;
import com.example.loginapi.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LoginRepositoryAdapter implements LoginRepository {

    private final LoginMongoRepository mongoRepository;

    @Override
    public List<Login> findAll() {
        return mongoRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Login> findById(String id) {
        return mongoRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Login save(Login login) {
        LoginEntity entity = toEntity(login);
        return toDomain(mongoRepository.save(entity));
    }

    @Override
    public void deleteById(String id) {
        mongoRepository.deleteById(id);
    }

    private Login toDomain(LoginEntity entity) {
        Login login = new Login();
        login.setId(entity.getId());
        login.setUsername(entity.getUsername());
        login.setPassword(entity.getPassword());
        login.setRoles(entity.getRoles());
        return login;
    }

    private LoginEntity toEntity(Login login) {
        LoginEntity entity = new LoginEntity();
        entity.setId(login.getId());
        entity.setUsername(login.getUsername());
        entity.setPassword(login.getPassword());
        entity.setRoles(login.getRoles());
        return entity;
    }
}
