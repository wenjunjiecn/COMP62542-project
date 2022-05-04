package com.uom.cs.studentsystem.studentunion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class SportsNewsletterEntity implements Serializable, BasicNewsletterEntity {
    private static final long serialVersionUID = 6687929992161255473L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String state;

    public SportsNewsletterEntity() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
