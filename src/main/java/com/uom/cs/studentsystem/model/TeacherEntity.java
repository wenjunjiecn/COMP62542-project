package com.uom.cs.studentsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @version 1.0 created by yixuan on 2022/4/29 0:15
 */
@Entity(name = "teacher")
public class TeacherEntity {
    @Id
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 简介
     */
    private String info;

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}