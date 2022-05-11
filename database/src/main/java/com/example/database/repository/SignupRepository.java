package com.example.database.repository;

import com.example.database.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepository extends JpaRepository<User, Integer> {
}
