package com.uom.cs.studentsystem.service.auth;


import com.uom.cs.studentsystem.model.VerifyData;

/**
 * @author wenjunjie
 * @version 1.0
 */
public interface VerifyStrategy {
    boolean verify(VerifyData data);
}
