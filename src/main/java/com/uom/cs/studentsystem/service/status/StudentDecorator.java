package com.uom.cs.studentsystem.service.status;

import com.uom.cs.studentsystem.service.studentunion.Subject;

public class StudentDecorator implements StudentBehavior{

    protected Student student;

    public StudentDecorator(Student student) {
        this.student = student;
    }


    @Override
    public void setSubject(Subject sub) {

    }

    @Override
    public void subscribeNewsletter(String type) {

    }

    @Override
    public void unsubscribeNewsletter(String type) {

    }
}
