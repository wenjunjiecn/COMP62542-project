package com.uom.cs.studentsystem.repository;

import com.uom.cs.studentsystem.model.StudentInboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInboxEntityRepository extends JpaRepository<StudentInboxEntity, String> {
}
