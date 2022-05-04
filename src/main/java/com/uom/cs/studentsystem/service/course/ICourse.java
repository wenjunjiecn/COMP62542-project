package com.uom.cs.studentsystem.service.course;

import com.uom.cs.studentsystem.service.status.Student;

/**
 * @author wenjunjie
 * @version 1.0
 */
public interface ICourse {
    void accept(Visitor visitor, Student student);
}
