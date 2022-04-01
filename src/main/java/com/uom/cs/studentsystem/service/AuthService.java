package com.uom.cs.studentsystem.service;

import com.uom.cs.studentsystem.model.User;
import com.uom.cs.studentsystem.model.VerifyData;
import com.uom.cs.studentsystem.repository.UserRepository;
import com.uom.cs.studentsystem.service.auth.VerifyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Service
@Transactional
public class AuthService {
    @Autowired
    private VerifyStrategy verifyStrategy;
    @Autowired
    private UserRepository userRepository;

    public User login(String id) {
        User user;
        VerifyData verifyData = new VerifyData();
        verifyData.addData("id", id);
        boolean verify = verifyStrategy.verify(verifyData);
        if (verify == true) {
            user = userRepository.getById(id);
        } else {
            user = new User();
        }
        return user;
    }
}
