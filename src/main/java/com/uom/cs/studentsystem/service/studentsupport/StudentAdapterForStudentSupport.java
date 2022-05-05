package com.uom.cs.studentsystem.service.studentsupport;

import com.uom.cs.studentsystem.model.CourseSelectionRecordEntity;
import com.uom.cs.studentsystem.repository.CourseSelectionRecordEntityRepository;
import com.uom.cs.studentsystem.service.status.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Component
@Scope("prototype")
public class StudentAdapterForStudentSupport implements OperateStudentCoursesList{
    Student student;

    public StudentAdapterForStudentSupport(Student student) {
        this.student=student;
    }


    @Override
    public boolean checkStudentPermission() {
        return this.student.hasCourseListPermission();
    }
}
