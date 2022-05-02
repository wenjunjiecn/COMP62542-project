package com.uom.cs.studentsystem.service.status;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class PendingRegisterStatus implements IRegisterStatus{
    @Override
    public String checkStatus() {
        return "Pending";
    }
}
