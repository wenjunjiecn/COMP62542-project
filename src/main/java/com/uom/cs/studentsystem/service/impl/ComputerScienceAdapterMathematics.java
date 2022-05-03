package com.uom.cs.studentsystem.service.impl;

import com.uom.cs.studentsystem.model.CurriculumEntity;
import com.uom.cs.studentsystem.service.ComputerScienceService;
import com.uom.cs.studentsystem.service.MathematicsService;

/**
 * 适配器类
 *
 * @author yixuan
 * @version 1.0
 * @date 2022/5/1 23:50
 */
public class ComputerScienceAdapterMathematics implements ComputerScienceService {

    private MathematicsService mathematicsService;

    public ComputerScienceAdapterMathematics(MathematicsService mathematicsService) {
        this.mathematicsService = mathematicsService;
    }

    @Override
    public CurriculumEntity insertComputerScience() {
        return mathematicsService.insertMathematics();
    }

    @Override
    public void deleteComputerScience() {
        mathematicsService.deleteMathematics();
    }
}
