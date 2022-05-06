package com.uom.cs.studentsystem.inbox.repository;

import com.uom.cs.studentsystem.inbox.model.StudentInboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInboxEntityRepository extends JpaRepository<StudentInboxEntity, String> {
}
