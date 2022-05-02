package com.uom.cs.studentsystem.repository;

import com.uom.cs.studentsystem.model.CurriculumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @version 1.0 created by yixuan on 2022/4/28 16:19
 */
public interface CurriculumEntityRepository extends JpaRepository<CurriculumEntity, Long> {
    List<CurriculumEntity> findAllBySubject(String subject);
}
