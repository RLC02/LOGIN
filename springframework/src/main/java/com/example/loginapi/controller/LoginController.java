package com.example.loginapi.controller;

import com.example.loginapi.model.Login;
import com.example.loginapi.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    
    private final LoginService service;

    @GetMapping
    public List<Login> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Login> getById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Login> create(@RequestBody Login login) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(login));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Login> update(@PathVariable String id, @RequestBody Login login) {
        return service.update(id, login)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
