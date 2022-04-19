package com.uom.cs.studentsystem.repository;

import com.uom.cs.studentsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wenjunjie
 * @version 1.0
 */
public interface StudentRepository extends JpaRepository<Student, String> {
}
