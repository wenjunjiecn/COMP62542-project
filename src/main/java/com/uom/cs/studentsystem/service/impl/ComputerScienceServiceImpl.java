package com.uom.cs.studentsystem.service.impl;

import com.uom.cs.studentsystem.model.CurriculumEntity;
import com.uom.cs.studentsystem.repository.CurriculumEntityRepository;
import com.uom.cs.studentsystem.service.ComputerScienceService;

/**
 * @author cen
 * @version 1.0
 * @date 2022/5/1 23:16
 */
public class ComputerScienceServiceImpl implements ComputerScienceService {

    private CurriculumEntity curriculumEntity;
    private CurriculumEntityRepository curriculumEntityRepository;

    public ComputerScienceServiceImpl(CurriculumEntity curriculumEntity, CurriculumEntityRepository curriculumEntityRepository) {
        this.curriculumEntity = curriculumEntity;
        this.curriculumEntityRepository = curriculumEntityRepository;
    }

    @Override
    public CurriculumEntity insertComputerScience() {
        return curriculumEntityRepository.save(this.curriculumEntity);
    }

    @Override
    public void deleteComputerScience() {
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
