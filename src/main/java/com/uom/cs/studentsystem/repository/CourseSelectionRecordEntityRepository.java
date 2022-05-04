package com.uom.cs.studentsystem.repository;

import com.uom.cs.studentsystem.model.CourseSelectionEntity;
import com.uom.cs.studentsystem.model.CourseSelectionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wenjunjie
 * @version 1.0
 */
public interface CourseSelectionRecordEntityRepository extends JpaRepository<CourseSelectionRecordEntity, Long> {
}
