package com.uom.cs.studentsystem.test;

import com.uom.cs.studentsystem.repository.AdditionalActivityEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Controller
public class TestResponsitory {
    @Autowired
    AdditionalActivityEntityRepository additionalActivityEntityRepository;

}
