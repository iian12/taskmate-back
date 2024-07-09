package com.jygoh.taskmate.domain.user.repository;

import com.jygoh.taskmate.domain.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
