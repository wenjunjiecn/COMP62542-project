package com.uom.cs.studentsystem.service.status;

//import com.sun.org.apache.xpath.internal.operations.Bool;

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
    public Boolean hasStudentUnionPermission() {
        return true;
    }
}
