package com.uom.cs.studentsystem.form;

/**
 * @author yixuan
 * @version 1.0
 * @date 2022/5/1 22:49
 */
public class CurriculumForm {
    /**
     * subject
     */
    private String subject;

    private Integer teacherId;

    /**
     * class_begin
     */
    private String classStartTime;

    /**
     * class_end
     */
    private String classEndTime;

    /**
     * class_date
     */
    private String classDate;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassStartTime() {
        return classStartTime;
    }

    public void setClassStartTime(String classStartTime) {
        this.classStartTime = classStartTime;
    }

    public String getClassEndTime() {
        return classEndTime;
    }

    public void setClassEndTime(String classEndTime) {
        this.classEndTime = classEndTime;
    }

    public String getClassDate() {
        return classDate;
    }

    public void setClassDate(String classDate) {
        this.classDate = classDate;
    }
}
