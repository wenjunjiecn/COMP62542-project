package com.uom.cs.studentsystem.repository;

import com.uom.cs.studentsystem.model.CourseSelectionEntity;
import com.uom.cs.studentsystem.model.CourseSelectionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wenjunjie
 * @version 1.0
 */
public interface CourseSelectionRecordEntityRepository extends JpaRepository<CourseSelectionRecordEntity, Long> {
    List<CourseSelectionRecordEntity> findAllByStudentId(String id);
    void deleteByCourseIdAndStudentId(Long courseId,String studentId);

}
