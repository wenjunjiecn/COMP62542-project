package com.uom.cs.studentsystem.service.studentsupport;

import com.uom.cs.studentsystem.service.status.Student;

/**
 * @author wenjunjie
 * @version 1.0
 */
public abstract class StudentAdapterTemplate implements OperateStudentCoursesList{
    private Student student;

    public StudentAdapterTemplate(Student student){
        this.student=student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    protected Student getStudent() {
        return student;
    }

    abstract void addMethod(Long courseid);
    abstract void removeMethod(Long courseid);
}
