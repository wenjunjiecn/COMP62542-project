package com.uom.cs.studentsystem.service.status;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class FullyRegisterStatus implements IRegisterStatus {
    @Override
    public String checkStatus() {
        return "Fully Register";
    }

    @Override
    public Boolean hasTimetablePermission() {
        return true;
    }

    @Override
    public Boolean hasCourseListOperationPermission() {
        return true;
    }

    @Override
    public Boolean hasStudentUnionPermission() {
        return true;
    }
}
