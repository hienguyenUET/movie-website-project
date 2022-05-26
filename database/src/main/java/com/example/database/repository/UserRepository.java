package com.example.database.repository;

import com.example.database.model.entity.Movie;
import com.example.database.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username) throws UsernameNotFoundException;
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
