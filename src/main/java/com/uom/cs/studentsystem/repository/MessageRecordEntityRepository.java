package com.uom.cs.studentsystem.repository;

import com.uom.cs.studentsystem.model.MessageRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRecordEntityRepository extends JpaRepository<MessageRecordEntity, String> {
}
