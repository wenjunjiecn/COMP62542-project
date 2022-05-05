package com.uom.cs.studentsystem.service.studentsupport;

import com.uom.cs.studentsystem.service.status.Student;

import java.io.Serializable;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class StudentSupport implements Serializable {
    private Student student;
    public StudentSupport(Student student){
        this.student=student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


}
