package com.uom.cs.studentsystem.studentunion.model;

import com.uom.cs.studentsystem.studentunion.Observer;
import com.uom.cs.studentsystem.studentunion.repository.AcademicNewsletterEntityRepository;
import com.uom.cs.studentsystem.studentunion.repository.SocialNewsletterEntityRepository;
import com.uom.cs.studentsystem.studentunion.repository.SportsNewsletterEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewsletterEntityFactory {

    @Autowired
    private SportsNewsletterEntityRepository sportsNewsletterEntityRepository;

    @Autowired
    private AcademicNewsletterEntityRepository academicNewsletterEntityRepository;

    @Autowired
    private SocialNewsletterEntityRepository socialNewsletterEntityRepository;

    public static BasicNewsletterEntity getNewsletterEntityFactory(Observer obj, String type) {
        if (type.equals("academic")) {
            AcademicNewsletterEntity academicNewsletterEntity = new AcademicNewsletterEntity();
            academicNewsletterEntity.setId(obj.studentId());
            academicNewsletterEntity.setState("subscribe");
            return academicNewsletterEntity;
        } else if (type.equals("sports")) {
            SportsNewsletterEntity sportsNewsletterEntity = new SportsNewsletterEntity();
            sportsNewsletterEntity.setId(obj.studentId());
            sportsNewsletterEntity.setState("subscribe");
            return sportsNewsletterEntity;
        } else if (type.equals("social")) {
            SocialNewsletterEntity socialNewsletterEntity = new SocialNewsletterEntity();
            socialNewsletterEntity.setId(obj.studentId());
            socialNewsletterEntity.setState("subscribe");
            return socialNewsletterEntity;
        } else {
            System.out.println("illegal subscribe type");
            return null;
        }
    }
}
