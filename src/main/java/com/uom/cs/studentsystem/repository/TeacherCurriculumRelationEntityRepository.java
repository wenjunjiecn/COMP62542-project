package com.uom.cs.studentsystem.repository;

import com.uom.cs.studentsystem.model.TeacherCurriculumRelationEntity;
import com.uom.cs.studentsystem.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @version 1.0 created by yixuan on 2022/4/28 16:19
 */
public interface TeacherCurriculumRelationEntityRepository extends JpaRepository<TeacherCurriculumRelationEntity, String> {
    TeacherCurriculumRelationEntity getByCurriculumId(Integer s);
}