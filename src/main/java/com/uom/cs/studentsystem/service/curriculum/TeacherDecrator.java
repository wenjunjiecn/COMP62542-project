package com.uom.cs.studentsystem.service.curriculum;

import com.uom.cs.studentsystem.model.CurriculumEntity;
import com.uom.cs.studentsystem.model.TeacherEntity;
import com.uom.cs.studentsystem.vo.CourseVO;
import org.springframework.beans.BeanUtils;

/**
 * @version 1.0 created by cenjiangyu on 2022/4/29 13:59
 */
public class TeacherDecrator extends CourseAbstract {

    private CourseAbstract courseAbstract;

    private TeacherEntity teacherEntity;

    @Override
    public CourseVO getCourse() {
        CurriculumEntity curriculumEntity = courseAbstract.getCurriculumEntity();
        CourseVO courseVO = new CourseVO();
        BeanUtils.copyProperties(curriculumEntity, courseVO);
        courseVO.setTeacher(teacherEntity.getName());
        return courseVO;
    }

    public TeacherDecrator(CourseAbstract courseAbstract, TeacherEntity teacherEntity) {
        super(courseAbstract.getSubject());
        this.courseAbstract = courseAbstract;
        this.teacherEntity = teacherEntity;
    }
}