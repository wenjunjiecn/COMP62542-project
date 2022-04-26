package com.uom.cs.studentsystem.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Entity
public class CourseSelectionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String studentid;
    @Column(nullable = false)
    private Long courseid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }
}
