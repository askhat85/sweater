package com.example.secondattempt.sweater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.secondattempt.sweater.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
