package com.uom.cs.studentsystem.service.impl;

import com.uom.cs.studentsystem.model.CurriculumEntity;
import com.uom.cs.studentsystem.repository.CurriculumEntityRepository;
import com.uom.cs.studentsystem.service.MathematicsService;

/**
 * @author yixuan
 * @version 1.0
 * @date 2022/5/1 23:44
 */
public class MathematicsServiceImpl implements MathematicsService {
    private CurriculumEntity curriculumEntity;
    private CurriculumEntityRepository curriculumEntityRepository;

    public MathematicsServiceImpl(CurriculumEntity curriculumEntity, CurriculumEntityRepository curriculumEntityRepository) {
        this.curriculumEntity = curriculumEntity;
        this.curriculumEntityRepository = curriculumEntityRepository;
    }

    @Override
    public CurriculumEntity insertMathematics() {
        return curriculumEntityRepository.save(curriculumEntity);
    }

    @Override
    public void deleteMathematics() {
            curriculumEntityRepository.deleteById(curriculumEntity.getId());
        }

    public CurriculumEntity getCurriculumEntity() {
        return curriculumEntity;
    }

    public void setCurriculumEntity(CurriculumEntity curriculumEntity) {
        this.curriculumEntity = curriculumEntity;
    }

    public CurriculumEntityRepository getCurriculumEntityRepository() {
        return curriculumEntityRepository;
    }

    public void setCurriculumEntityRepository(CurriculumEntityRepository curriculumEntityRepository) {
        this.curriculumEntityRepository = curriculumEntityRepository;
    }
}
