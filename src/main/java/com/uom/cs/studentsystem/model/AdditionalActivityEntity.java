package com.uom.cs.studentsystem.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Entity
public class AdditionalActivityEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String studentid;
    @Column(nullable = false)
    private Integer dayInWeek;
    @Column(nullable = false)
    private String startTime;
    @Column(nullable = false)
    private String endTime;
    private String message;


    private static final long serialVersionUID = 6687929992161255473L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public Integer getDayInWeek() {
        return dayInWeek;
    }

    public void setDayInWeek(Integer dayInWeek) {
        this.dayInWeek = dayInWeek;
    }

    @Override
    public String toString() {
        return "AdditionalActivityEntity{" +
                "id=" + id +
                ", studentid='" + studentid + '\'' +
                ", dayInWeek=" + dayInWeek +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
