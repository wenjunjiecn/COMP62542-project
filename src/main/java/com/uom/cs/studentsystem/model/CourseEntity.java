package com.uom.cs.studentsystem.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Entity
public class CourseEntity implements Serializable {
    private static final long serialVersionUID = 6687929992161255473L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String courseName;
    @Column(nullable = false)
    private String startTime;
    @Column(nullable = false)
    private Integer dayInWeek;
    @Column(nullable = false)
    private String endTime;
    @Column(nullable = false)
    private boolean isOptionalCourse;

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

    public Integer getDayInWeek() {
        return dayInWeek;
    }

    public void setDayInWeek(Integer dayInWeek) {
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
}
