package com.uom.cs.studentsystem.service.curriculum;

import com.uom.cs.studentsystem.model.CurriculumEntity;
import com.uom.cs.studentsystem.utils.ConstantUtils;

/**
 * 计算机科学
 *
 * @version 1.0 created by cenjiangyu on 2022/4/29 11:18
 */
public class ComputerScience extends CourseAbstract {
    @Override
    public CurriculumEntity getCourse() {
        return getCurriculumEntity();
    }

    public ComputerScience(CurriculumEntity curriculumEntity) {
        super(ConstantUtils.COMPUTER_SCIENCE);
        setCurriculumEntity(curriculumEntity);
    }
}