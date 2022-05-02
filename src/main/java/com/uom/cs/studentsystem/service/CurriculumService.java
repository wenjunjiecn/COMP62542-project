package com.uom.cs.studentsystem.service;

import com.uom.cs.studentsystem.model.CurriculumEntity;
import com.uom.cs.studentsystem.service.curriculum.ComputerScience;

import java.util.List;

/**
 * @author cen
 * @version 1.0
 * @date 2022/5/1 22:39
 */
public interface CurriculumService {
    /**查询课程*/
    List<CurriculumEntity> queryCurriculumBySubject(String subject, String studentId);

    /**新增课程*/
    CurriculumEntity insertComputerScience(ComputerScienceService computerScienceService);

    /**删除课程*/
    void deleteComputerScience(ComputerScienceService computerScienceService);
}
