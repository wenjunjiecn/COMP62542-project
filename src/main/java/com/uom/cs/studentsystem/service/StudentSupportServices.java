package com.uom.cs.studentsystem.service;

import com.uom.cs.studentsystem.model.CourseSelectionRecordEntity;
import com.uom.cs.studentsystem.model.StudentEntity;
import com.uom.cs.studentsystem.repository.CourseSelectionRecordEntityRepository;
import com.uom.cs.studentsystem.repository.StudentEntityRepository;
import com.uom.cs.studentsystem.service.CourseService;
import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.service.course.CourseItemVO;
import com.uom.cs.studentsystem.service.studentsupport.StudentAdapterForStudentSupport;
import com.uom.cs.studentsystem.service.studentsupport.StudentSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Service
@Transactional
public class StudentSupportServices {
    @Autowired
    StudentEntityRepository studentEntityRepository;
    @Autowired
    CourseSelectionRecordEntityRepository courseSelectionRecordEntityRepository;
    @Autowired
    CourseService courseService;
    public void addCourseForStudent(StudentSupport studentSupport, Long courseid){
        StudentAdapterForStudentSupport adapter = new StudentAdapterForStudentSupport(studentSupport.getStudent());
        if(adapter.checkStudentPermission()){
            CourseSelectionRecordEntity entity = new CourseSelectionRecordEntity();
            entity.setCourseId(courseid);
            entity.setStudentId(studentSupport.getStudent().getId());
            courseSelectionRecordEntityRepository.saveAndFlush(entity);
        }
    }
    public void removeCourseForStudent(StudentSupport studentSupport,Long courseid){
        StudentAdapterForStudentSupport adapter = new StudentAdapterForStudentSupport(studentSupport.getStudent());
        if (adapter.checkStudentPermission()) {
            courseSelectionRecordEntityRepository.deleteByCourseIdAndStudentId(courseid,studentSupport.getStudent().getId());
        }
    }

    public Student createStudent(String studentid) {
        StudentEntity studentEntity = studentEntityRepository.getById(studentid);
        Student student = new Student(studentEntity);
        return student;
    }
    public List<CourseItemVO> getCourseList(Student student){
        List<CourseItemVO> allCourse = courseService.getAllCourse(student.getId());
        return allCourse;

    }
}
