package com.uom.cs.studentsystem.repository;

import com.uom.cs.studentsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wenjunjie
 * @version 1.0
 */
public interface UserRepository extends JpaRepository<User, String> {
}
