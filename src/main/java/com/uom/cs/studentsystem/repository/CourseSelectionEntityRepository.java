package com.uom.cs.studentsystem.repository;

import com.uom.cs.studentsystem.model.AdditionalActivityEntity;
import com.uom.cs.studentsystem.model.CourseSelectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wenjunjie
 * @version 1.0
 */
public interface CourseSelectionEntityRepository extends JpaRepository<CourseSelectionEntity, Long> {
    List<CourseSelectionEntity> findByStudentid(String studentid);
}
