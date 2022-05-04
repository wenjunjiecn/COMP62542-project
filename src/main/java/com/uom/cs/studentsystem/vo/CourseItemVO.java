package com.uom.cs.studentsystem.vo;

import com.uom.cs.studentsystem.model.CourseEntity;

import javax.persistence.Column;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class CourseItemVO {
    private Long id;

    private String courseName;

    private String startTime;

    private String dayInWeek;

    private String endTime;

    private boolean isOptionalCourse;

    private Boolean selectFlag;

    private static Map<Integer,String> dayInWeekMap=new HashMap<>();
    static {
        dayInWeekMap.put(1,"Monday");
        dayInWeekMap.put(2,"Tuesday");
        dayInWeekMap.put(3,"Wednesday");
        dayInWeekMap.put(4,"Thursday");
        dayInWeekMap.put(5,"Friday");
        dayInWeekMap.put(6,"Saturday");
        dayInWeekMap.put(7,"Sunday");
    }


    private String department;
    public CourseItemVO(CourseEntity entity){
        this.id=entity.getId();
        this.courseName=entity.getCourseName();
        this.startTime=entity.getStartTime();
        this.endTime=entity.getEndTime();
        this.dayInWeek=dayInWeekMap.get(entity.getDayInWeek());
        this.isOptionalCourse=entity.isOptionalCourse();
        this.department=entity.getDepartment();
    }

    public void setSelectFlag(Boolean selectFlag) {
        this.selectFlag = selectFlag;
    }

    public Boolean getSelectFlag() {
        return selectFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDayInWeek() {
        return dayInWeek;
    }

    public void setDayInWeek(String dayInWeek) {
        this.dayInWeek = dayInWeek;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isOptionalCourse() {
        return isOptionalCourse;
    }

    public void setOptionalCourse(boolean optionalCourse) {
        isOptionalCourse = optionalCourse;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "CourseItemVO{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", dayInWeek=" + dayInWeek +
                ", endTime='" + endTime + '\'' +
                ", isOptionalCourse=" + isOptionalCourse +
                ", selectFlag=" + selectFlag +
                ", department='" + department + '\'' +
                '}';
    }
}
