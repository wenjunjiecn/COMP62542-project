package com.uom.cs.studentsystem.service;

import com.uom.cs.studentsystem.bo.Student;
import com.uom.cs.studentsystem.model.StudentEntity;
import com.uom.cs.studentsystem.repository.StudentEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Service
public class StudentService {
    @Autowired
    private StudentEntityRepository studentEntityRepository;

    public String getRegisterStatus(String id){
        StudentEntity studentEntity = studentEntityRepository.getById(id);
        Student student = new Student(studentEntity);
        return student.checkRegisterStatus();
    }

}
