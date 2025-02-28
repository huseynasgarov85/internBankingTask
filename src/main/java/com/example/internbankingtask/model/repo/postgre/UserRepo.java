package com.example.internbankingtask.model.repo;

import com.example.internbankingtask.model.entity.postgre.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
