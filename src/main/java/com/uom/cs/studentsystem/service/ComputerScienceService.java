package com.uom.cs.studentsystem.service;

import com.uom.cs.studentsystem.model.CurriculumEntity;

/**
 *计算机科学service
 * @author cen
 * @version 1.0
 * @date 2022/5/1 22:31
 */
public interface ComputerScienceService {
    //新增课程
    CurriculumEntity insertComputerScience();

    // 删除课程
    void deleteComputerScience();
}
