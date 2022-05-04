package com.uom.cs.studentsystem.service.course;

import com.uom.cs.studentsystem.service.status.Student;

/**
 * @author wenjunjie
 * @version 1.0
 */
public interface Visitor {
    void visit(ComputerCourse computerCourse,Student student);
    void visit(MathmaticCourse mathmaticCourse,Student student);
}
