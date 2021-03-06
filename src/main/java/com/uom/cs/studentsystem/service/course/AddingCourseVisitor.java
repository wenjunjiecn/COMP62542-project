package com.uom.cs.studentsystem.service.course;

import com.uom.cs.studentsystem.model.CourseEntity;
import com.uom.cs.studentsystem.model.CourseSelectionRecordEntity;
import com.uom.cs.studentsystem.repository.CourseSelectionRecordEntityRepository;
import com.uom.cs.studentsystem.service.status.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Component
public class AddingCourseVisitor implements Visitor {
    @Autowired
    CourseSelectionRecordEntityRepository courseSelectionRecordEntityRepository;
    @Override
    public void visit(ComputerCourse computerCourse, Student student) {
        CourseSelectionRecordEntity entity = new CourseSelectionRecordEntity();
        entity.setCourseId(computerCourse.getId());
        entity.setStudentId(student.getId());
        courseSelectionRecordEntityRepository.saveAndFlush(entity);

    }

    @Override
    public void visit(MathmaticCourse mathmaticCourse, Student student) {
        CourseSelectionRecordEntity entity = new CourseSelectionRecordEntity();
        entity.setCourseId(mathmaticCourse.getId());
        entity.setStudentId(student.getId());
        courseSelectionRecordEntityRepository.saveAndFlush(entity);
    }
}
