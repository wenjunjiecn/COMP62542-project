package com.uom.cs.studentsystem.vo;

import com.uom.cs.studentsystem.model.CurriculumEntity;

/**
 * 课程返回模型
 *
 * @version 1.0 created by cenjiangyu on 2022/4/29 11:24
 */
public class CourseVO extends CurriculumEntity {
    private String teacher;

    private Boolean selectFlag;

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Boolean getSelectFlag() {
        return selectFlag;
    }

    public void setSelectFlag(Boolean selectFlag) {
        this.selectFlag = selectFlag;
    }
}