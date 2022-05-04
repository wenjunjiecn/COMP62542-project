package com.uom.cs.studentsystem.service;

import com.uom.cs.studentsystem.service.course.*;
import com.uom.cs.studentsystem.service.status.Student;
import org.springframework.stereotype.Service;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Service
public class CourseService {
    public void addCourse(Student student ){
        Visitor v= new AddingCourseVisitor();
        ICourse course = new ComputerCourse();
        course.accept(v,student);
    }
}
