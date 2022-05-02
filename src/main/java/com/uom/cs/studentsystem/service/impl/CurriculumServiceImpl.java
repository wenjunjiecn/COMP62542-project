package com.uom.cs.studentsystem.service.impl;

import com.uom.cs.studentsystem.model.CourseSelectionEntity;
import com.uom.cs.studentsystem.model.CurriculumEntity;
import com.uom.cs.studentsystem.model.TeacherEntity;
import com.uom.cs.studentsystem.repository.CourseSelectionEntityRepository;
import com.uom.cs.studentsystem.repository.CurriculumEntityRepository;
import com.uom.cs.studentsystem.repository.TeacherCurriculumRelationEntityRepository;
import com.uom.cs.studentsystem.repository.TeacherEntityRepository;
import com.uom.cs.studentsystem.service.ComputerScienceService;
import com.uom.cs.studentsystem.service.CurriculumService;
import com.uom.cs.studentsystem.service.curriculum.ComputerScience;
import com.uom.cs.studentsystem.service.curriculum.Mathematics;
import com.uom.cs.studentsystem.service.curriculum.TeacherDecrator;
import com.uom.cs.studentsystem.utils.ConstantUtils;
import com.uom.cs.studentsystem.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version 1.0 created by cenjiangyu on 2022/4/28 16:21
 */
@Service
public class CurriculumServiceImpl implements CurriculumService {

    @Autowired
    private CurriculumEntityRepository curriculumEntityRepository;

    @Autowired
    private TeacherEntityRepository teacherEntityRepository;

    @Autowired
    private CourseSelectionEntityRepository courseSelectionEntityRepository;

    @Autowired
    private TeacherCurriculumRelationEntityRepository teacherCurriculumRelationEntityRepository;


    @Override
    public List<CurriculumEntity> queryCurriculumBySubject(String subject, String studentId) {
        List<CurriculumEntity> curriculumEntityList = curriculumEntityRepository.findAllBySubject(subject);
        List<Integer> courselist = new ArrayList<>();
        if (studentId != null){
           courselist = courseSelectionEntityRepository.findAllByStudentId(Integer.parseInt(studentId)).stream().map(CourseSelectionEntity::getCurriculumId).collect(Collectors.toList());
        }
        List<Integer> finalCourselist = courselist;
        return curriculumEntityList.stream().map(e -> buildCourseVo(e, subject, finalCourselist)).collect(Collectors.toList());
    }

    @Override
    public CurriculumEntity insertComputerScience(ComputerScienceService computerScienceService) {
        return computerScienceService.insertComputerScience();
    }

    @Override
    public void deleteComputerScience(ComputerScienceService computerScienceService) {
        computerScienceService.deleteComputerScience();
    }

    /**
     * 构建课程
     *
     * @param curriculumEntity
     * @param courselist
     * @return
     */
    private CourseVO buildCourseVo(CurriculumEntity curriculumEntity, String subject, List<Integer> courselist) {
        if (ConstantUtils.COMPUTER_SCIENCE.equals(subject)) {
            ComputerScience computerScience = new ComputerScience(curriculumEntity);
            Integer teacherId = teacherCurriculumRelationEntityRepository.getByCurriculumId(computerScience.getCurriculumEntity().getId().intValue()).getTeacherId();
            TeacherDecrator teacherDecrator = new TeacherDecrator(computerScience, teacherEntityRepository.findById(teacherId.toString()).orElse(new TeacherEntity()));
            CourseVO course = teacherDecrator.getCourse();
            course.setSelectFlag(courselist.contains(curriculumEntity.getId().intValue()));
            return course;
        } else {
            Mathematics mathematics = new Mathematics(curriculumEntity);
            Integer teacherId = teacherCurriculumRelationEntityRepository.getByCurriculumId(mathematics.getCurriculumEntity().getId().intValue()).getTeacherId();
            TeacherDecrator teacherDecrator = new TeacherDecrator(mathematics, teacherEntityRepository.findById(teacherId.toString()).orElse(new TeacherEntity()));
            CourseVO course = teacherDecrator.getCourse();
            course.setSelectFlag(courselist.contains(curriculumEntity.getId().intValue()));
            return course;
        }
    }

    public void saveCourseSelection(CourseSelectionEntity courseSelectionEntity) {
        courseSelectionEntityRepository.save(courseSelectionEntity);
    }

    public void deleteCourse(Long id){
        curriculumEntityRepository.deleteById(id);
    }
}