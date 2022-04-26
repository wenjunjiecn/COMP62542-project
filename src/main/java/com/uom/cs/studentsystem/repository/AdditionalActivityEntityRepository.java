package com.uom.cs.studentsystem.repository;

import com.uom.cs.studentsystem.model.AdditionalActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wenjunjie
 * @version 1.0
 */
public interface AdditionalActivityEntityRepository extends JpaRepository<AdditionalActivityEntity, Long> {
    List<AdditionalActivityEntity> findByStudentid(String studentid);


}
