package com.uom.cs.studentsystem.service.curriculum;

import com.uom.cs.studentsystem.model.CurriculumEntity;
import com.uom.cs.studentsystem.utils.ConstantUtils;

/**
 * 数学
 *
 * @version 1.0 created by cenjiangyu on 2022/4/29 11:19
 */
public class Mathematics extends CourseAbstract {
    public Mathematics(CurriculumEntity curriculumEntity) {
        super(ConstantUtils.MATHEMATICS);
        setCurriculumEntity(curriculumEntity);
    }

    @Override
    public CurriculumEntity getCourse() {
        return getCurriculumEntity();
    }
}