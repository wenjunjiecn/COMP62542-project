package com.uom.cs.studentsystem.service.status;

import java.io.Serializable;

/**
 * @author wenjunjie
 * @version 1.0
 */
public interface IRegisterStatus extends Serializable {
    String checkStatus();

    default Boolean hasTimetablePermission() {
        return false;
    }

    default Boolean hasCourseListOperationPermission(){
        return false;
    }

    default Boolean hasStudentUnionPermission() {
        return false;
    }

}
