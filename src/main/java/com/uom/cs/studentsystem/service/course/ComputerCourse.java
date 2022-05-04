package com.uom.cs.studentsystem.service.course;

import com.uom.cs.studentsystem.service.status.Student;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class ComputerCourse implements ICourse{
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void accept(Visitor visitor, Student student) {
        visitor.visit(this,student);
    }
}
