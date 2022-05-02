package com.uom.cs.studentsystem.service.curriculum;

import com.uom.cs.studentsystem.model.CurriculumEntity;

/**
 * 课程抽象类
 *
 * @version 1.0 created by cenjiangyu on 2022/4/29 11:15
 */
public abstract class CourseAbstract {
    /**
     * 学科
     */
    private String subject;

    /**
     * 课程实体
     */
    private CurriculumEntity curriculumEntity;

    public abstract CurriculumEntity getCourse();


    public CourseAbstract(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public CurriculumEntity getCurriculumEntity() {
        return curriculumEntity;
    }

    public void setCurriculumEntity(CurriculumEntity curriculumEntity) {
        this.curriculumEntity = curriculumEntity;
    }
}
