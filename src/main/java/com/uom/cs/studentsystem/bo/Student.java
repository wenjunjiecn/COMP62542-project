package com.uom.cs.studentsystem.bo;

import com.uom.cs.studentsystem.model.StudentEntity;
import com.uom.cs.studentsystem.service.status.IRegisterStatus;
import com.uom.cs.studentsystem.service.status.RegisterStatusFactory;

/**
 * @author wenjunjie
 * @version 1.0
 * Student Business Object used in Services level
 */
public class Student {
    private String id;
    private String name;
    private IRegisterStatus registerStatus;

    /**
     * Generate StudentBo object from Student object
     */
    public Student(StudentEntity studentEntity) {
        this.id= studentEntity.getId();
        this.name= studentEntity.getName();
        this.registerStatus= RegisterStatusFactory.getRegisterStatus(studentEntity.getState());
    }

    /**
     * Check StudentRegisterStatus
     * @return String
     */
    public String checkRegisterStatus(){
        return registerStatus.checkStatus();
    }
}
