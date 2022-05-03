package com.uom.cs.studentsystem.studentunion.repository;

import com.uom.cs.studentsystem.studentunion.model.SportsNewsletterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsNewsletterEntityRepository extends JpaRepository<SportsNewsletterEntity, String> {
}

/*
create table sportsnewsletter(
 id varchar(255) primary key,
 state varchar(255)
);
 */