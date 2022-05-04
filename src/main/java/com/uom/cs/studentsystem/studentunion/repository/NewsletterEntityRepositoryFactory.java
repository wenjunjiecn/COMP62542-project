package com.uom.cs.studentsystem.studentunion.repository;


import com.uom.cs.studentsystem.studentunion.model.AcademicNewsletterEntity;
import com.uom.cs.studentsystem.studentunion.model.BasicNewsletterEntity;
import com.uom.cs.studentsystem.studentunion.model.SocialNewsletterEntity;
import com.uom.cs.studentsystem.studentunion.model.SportsNewsletterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NewsletterEntityRepositoryFactory {

    @Autowired
    private SportsNewsletterEntityRepository sportsNewsletterEntityRepository;

    @Autowired
    private AcademicNewsletterEntityRepository academicNewsletterEntityRepository;

    @Autowired
    private SocialNewsletterEntityRepository socialNewsletterEntityRepository;

    public void saveEntity(BasicNewsletterEntity basicNewsletterEntity) {
        if (basicNewsletterEntity instanceof AcademicNewsletterEntity) {
            academicNewsletterEntityRepository.saveAndFlush((AcademicNewsletterEntity) basicNewsletterEntity);
        } else if (basicNewsletterEntity instanceof SportsNewsletterEntity) {
            sportsNewsletterEntityRepository.saveAndFlush((SportsNewsletterEntity) basicNewsletterEntity);
        } else if (basicNewsletterEntity instanceof SocialNewsletterEntity) {
            socialNewsletterEntityRepository.saveAndFlush((SocialNewsletterEntity) basicNewsletterEntity);
        } else {
            System.out.println("illegal subscribe type");
        }
    }
}
