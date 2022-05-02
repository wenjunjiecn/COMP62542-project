package com.uom.cs.studentsystem.service.status;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class NotRegisterStatus implements IRegisterStatus{
    @Override
    public String checkStatus() {
        return "Not Register";
    }
}
