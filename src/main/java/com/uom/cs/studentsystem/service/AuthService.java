package com.uom.cs.studentsystem.service;

import com.uom.cs.studentsystem.model.StudentEntity;
import com.uom.cs.studentsystem.model.VerifyData;
import com.uom.cs.studentsystem.repository.StudentEntityRepository;
import com.uom.cs.studentsystem.service.auth.VerifyStrategy;
import com.uom.cs.studentsystem.service.status.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Service
@Transactional
public class AuthService {
    @Autowired
    private VerifyStrategy verifyStrategy;
    @Autowired
    private StudentEntityRepository studentEntityRepository;

    public Student login(String id) {
        StudentEntity studentEntity = null;
        Student student = null;
        VerifyData verifyData = new VerifyData();
        verifyData.addData("id", id);
        boolean verify = verifyStrategy.verify(verifyData);
        if (verify == true) {
            studentEntity = studentEntityRepository.getById(id);
            student = new Student(studentEntity);
            System.out.println(studentEntity);
        }
        return student;
    }
}
