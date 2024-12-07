package com.certtracker.service;

import com.certtracker.model.Role;
import com.certtracker.model.User;
import com.certtracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllStudents() {
        return userRepository.findAll().stream()
            .filter(user -> user.getRole() == Role.STUDENT)
            .toList();
    }
} 