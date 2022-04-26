package com.uom.cs.studentsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Entity
public class StudentEntity implements Serializable {
    private static final long serialVersionUID = 6687929992161255473L;
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String name;

    private String state;


    public StudentEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
