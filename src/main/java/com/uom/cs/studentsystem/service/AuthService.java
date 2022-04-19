package com.uom.cs.studentsystem.service;

import com.uom.cs.studentsystem.model.Student;
import com.uom.cs.studentsystem.model.VerifyData;
import com.uom.cs.studentsystem.repository.StudentRepository;
import com.uom.cs.studentsystem.service.auth.VerifyStrategy;
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
    private StudentRepository studentRepository;

    public Student login(String id) {
        Student student = null;
        VerifyData verifyData = new VerifyData();
        verifyData.addData("id", id);
        boolean verify = verifyStrategy.verify(verifyData);
        if (verify == true) {
            student = studentRepository.getById(id);
            System.out.println(student);
        }
        return student;
    }
}
