package com.example.repository;

import com.example.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by szymon on 08.06.16.
 */
public interface UserRepository extends JpaRepository<Users, Long> {
}
