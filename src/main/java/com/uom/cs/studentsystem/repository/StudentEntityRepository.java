package com.uom.cs.studentsystem.repository;

import com.uom.cs.studentsystem.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wenjunjie
 * @version 1.0
 */
public interface StudentEntityRepository extends JpaRepository<StudentEntity, String> {

}
