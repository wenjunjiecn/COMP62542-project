package com.uom.cs.studentsystem.service.status;

import com.uom.cs.studentsystem.model.StudentEntity;

import java.io.Serializable;

/**
 * @author wenjunjie
 * @version 1.0
 * Student Business Object used in Services level
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 6687929992161255473L;
    private String id;
    private String name;
    private IRegisterStatus registerStatus;

    /**
     * Generate StudentBo object from Student object
     */
    public Student(StudentEntity studentEntity) {
        this.id = studentEntity.getId();
        this.name = studentEntity.getName();
        this.registerStatus = RegisterStatusFactory.getRegisterStatus(studentEntity.getState());
    }

    /**
     * Check StudentRegisterStatus
     *
     * @return String
     */
    public String checkRegisterStatus() {
        return registerStatus.checkStatus();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean hasTimeTablePermission() {
        return registerStatus.hasTimetablePermission();
    }
}
