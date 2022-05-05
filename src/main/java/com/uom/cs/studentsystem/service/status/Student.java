package com.uom.cs.studentsystem.service.status;

import com.uom.cs.studentsystem.model.StudentEntity;
import org.hibernate.annotations.Comment;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.io.Serializable;

/**
 * @author wenjunjie
 * @version 1.0
 * Student Business Object used in Services level
 */
@Component
@Scope("prototype")
public class Student implements Serializable {
    private static final long serialVersionUID = 6687929992161255473L;
    private String id;
    private String name;
    private IRegisterStatus registerStatus;
//    private ObserverOfStudentUnion observerOfStudentUnion;

    /**
     * Generate StudentBo object from Student object
     */
    public Student(StudentEntity studentEntity) {
        this.id = studentEntity.getId();
        this.name = studentEntity.getName();
        this.registerStatus = RegisterStatusFactory.getRegisterStatus(studentEntity.getState());
//        this.observerOfStudentUnion = new ObserverOfStudentUnion(this);
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

    public Boolean hasCourseListPermission(){
        return registerStatus.hasCourseListOperationPermission();
    }
}
