package com.uom.cs.studentsystem.repository;

import com.uom.cs.studentsystem.model.CurriculumEntity;
import com.uom.cs.studentsystem.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @version 1.0 created by yixuan on 2022/4/28 16:19
 */
public interface TeacherEntityRepository extends JpaRepository<TeacherEntity, String> {

}