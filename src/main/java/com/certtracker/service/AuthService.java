package com.certtracker.service;

import com.certtracker.dto.LoginRequest;
import com.certtracker.model.User;
import com.certtracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        return userRepository.findByUsername(loginRequest.getUsername())
            .filter(user -> passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
            .map(user -> ResponseEntity.ok().body("Login successful"))
            .orElse(ResponseEntity.badRequest().body("Invalid credentials"));
    }
} 