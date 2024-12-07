package com.certtracker.repository;

import com.certtracker.model.Role;
import com.certtracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Basic findAll() is already inherited from JpaRepository
    
    // Custom findAll with specific fields
    @Query("SELECT u FROM User u ORDER BY u.username")
    List<User> findAll();
    
    // Find all users with certificates
    @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.certificates")
    List<User> findAllWithCertificates();
    
    // Find all by role (e.g., all students)
    List<User> findByRole(Role role);
    
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
} 