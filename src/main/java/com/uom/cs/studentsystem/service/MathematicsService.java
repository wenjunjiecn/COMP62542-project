package com.uom.cs.studentsystem.service;

import com.uom.cs.studentsystem.model.CurriculumEntity;

/**
 * @author cen
 * @version 1.0
 * @date 2022/5/1 23:43
 */
public interface MathematicsService {
    //新增课程
    CurriculumEntity insertMathematics();

    // 删除课程
    void deleteMathematics();
}
