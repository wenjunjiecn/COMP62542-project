package com.uom.cs.studentsystem.repository;

import com.uom.cs.studentsystem.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author wenjunjie
 * @version 1.0
 */
public interface CourseEntityRepository extends JpaRepository<CourseEntity, Long> {


}
