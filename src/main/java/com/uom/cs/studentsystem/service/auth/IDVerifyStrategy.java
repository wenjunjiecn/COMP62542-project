package com.uom.cs.studentsystem.service.auth;

import com.uom.cs.studentsystem.model.VerifyData;
import com.uom.cs.studentsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Component
public class IDVerifyStrategy implements VerifyStrategy {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean verify(VerifyData data) {
        String id = (String) data.getByKey("id");
        boolean hasUser = userRepository.existsById("id");
        if (hasUser) {
            return true;
        }
        return false;
    }
}
