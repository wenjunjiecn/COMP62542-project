package com.uom.cs.studentsystem.service.course;

import com.uom.cs.studentsystem.model.CourseSelectionRecordEntity;
import com.uom.cs.studentsystem.repository.CourseSelectionRecordEntityRepository;
import com.uom.cs.studentsystem.service.status.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Component
@Transactional
public class RemoveCourseVisitor implements Visitor{
    @Autowired
    CourseSelectionRecordEntityRepository courseSelectionRecordEntityRepository;
    @Override
    public void visit(ComputerCourse computerCourse, Student student) {
        courseSelectionRecordEntityRepository.deleteByCourseIdAndStudentId(computerCourse.getId(),student.getId());
    }

    @Override
    public void visit(MathmaticCourse mathmaticCourse, Student student) {
        courseSelectionRecordEntityRepository.deleteByCourseIdAndStudentId(mathmaticCourse.getId(),student.getId());
    }
}
