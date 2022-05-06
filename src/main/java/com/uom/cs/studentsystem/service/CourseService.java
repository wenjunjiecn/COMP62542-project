package com.uom.cs.studentsystem.service;

import com.uom.cs.studentsystem.model.CourseEntity;
import com.uom.cs.studentsystem.repository.CourseEntityRepository;
import com.uom.cs.studentsystem.repository.CourseSelectionRecordEntityRepository;
import com.uom.cs.studentsystem.service.course.AddingCourseVisitor;
import com.uom.cs.studentsystem.service.course.CourseFactory;
import com.uom.cs.studentsystem.service.course.ICourse;
import com.uom.cs.studentsystem.service.course.RemoveCourseVisitor;
import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.vo.CourseItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Service
public class CourseService {
    @Autowired
    CourseEntityRepository courseEntityRepository;
    @Autowired
    CourseSelectionRecordEntityRepository courseSelectionRecordEntityRepository;
    @Autowired
    AddingCourseVisitor addingCourseVisitor;
    @Autowired
    RemoveCourseVisitor removeCourseVisitor;

    public void addCourse(Student student, String department,String courseid){
//        Visitor v= new AddingCourseVisitor();
        ICourse course = CourseFactory.create(department, courseid);
        course.accept(addingCourseVisitor,student);
    }
    public void removeCourse(Student student,String department,String courseid){
//        Visitor v= new RemoveCourseVisitor();
        ICourse course = CourseFactory.create(department, courseid);
        course.accept(removeCourseVisitor,student);
    }

    public List<CourseItemVO> getAllCourse(String id){
        List<CourseEntity> all = courseEntityRepository.findAll();
        List<Long> seletedList = courseSelectionRecordEntityRepository.findAllByStudentId(id).stream().map(i -> i.getCourseId()).collect(Collectors.toList());
        List<CourseItemVO> finalList = all.stream().map(i -> buildCourseVo(i, seletedList)).collect(Collectors.toList());
        return finalList;
    }

    private CourseItemVO buildCourseVo(CourseEntity i, List<Long> all) {
        CourseItemVO courseItemVO = new CourseItemVO(i);
        if(all.contains(i.getId())){
            courseItemVO.setSelectFlag(true);
        }else{
            courseItemVO.setOptionalCourse(false);
        }
        return courseItemVO;
    }
}
