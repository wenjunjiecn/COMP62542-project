package com.uom.cs.studentsystem.studentunion.service;

import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.studentunion.ObserverOfStudentUnion;
import com.uom.cs.studentsystem.studentunion.StudentUnion;
import com.uom.cs.studentsystem.studentunion.model.AcademicNewsletterEntity;
import com.uom.cs.studentsystem.studentunion.model.SportsNewsletterEntity;
import com.uom.cs.studentsystem.studentunion.repository.AcademicNewsletterEntityRepository;
import com.uom.cs.studentsystem.studentunion.repository.SportsNewsletterEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//应该用装饰器模式重构一下
@Service
public class StudentUnionService {
    //@Autowired
    //private SportsNewsletterEntityRepository sportsNewsletterEntityRepository;

    //@Autowired
    //private AcademicNewsletterEntityRepository academicNewsletterEntityRepository;

    @Autowired
    private StudentUnion studentUnion;

    public String getSubscribeStatus(String id, String type) {
        if (studentUnion.getSubscribeStatus(id, type)) {
            return "subscribe";
        } else {
            return "unsubscribe";
        }
        //return studentUnion.getSubscribeStatus(id, type);
//        if (type.equals("academic")) {
//            AcademicNewsletterEntity academicNewsletterEntity = academicNewsletterEntityRepository.getById(id);
//            return academicNewsletterEntity.getState();
//        } else if (type.equals("sports")) {
//            SportsNewsletterEntity sportsNewsletterEntity = sportsNewsletterEntityRepository.getById(id);
//            return sportsNewsletterEntity.getState();
//        } else {
//            System.out.println("illegal subscribe type");
//            return "Error";
//        }
    }

    public void subscribeNewsletter(Student student, String type) {
//        if (type.equals("academic")) {
//            AcademicNewsletterEntity academicNewsletterEntity = new AcademicNewsletterEntity();
//            academicNewsletterEntity.setId(id);
//            academicNewsletterEntity.setState("subscribe");
//            academicNewsletterEntityRepository.saveAndFlush(academicNewsletterEntity);
//        } else if (type.equals("sports")) {
//            SportsNewsletterEntity sportsNewsletterEntity = new SportsNewsletterEntity();
//            sportsNewsletterEntity.setId(id);
//            sportsNewsletterEntity.setState("subscribe");
//            sportsNewsletterEntityRepository.saveAndFlush(sportsNewsletterEntity);
//        } else {
//            System.out.println("illegal subscribe type");
//        }
        ObserverOfStudentUnion studentDecoretor = new ObserverOfStudentUnion(student);
        studentUnion.register(studentDecoretor);
        studentUnion.subscribeSpecificNewsletter(studentDecoretor, type);

    }

    public void unsubscribeNewsletter(Student student, String type) {
//        if (type.equals("academic")) {
//            academicNewsletterEntityRepository.deleteById(id);
//        } else if (type.equals("sports")) {
//            sportsNewsletterEntityRepository.deleteById(id);
//        } else {
//            System.out.println("illegal unsubscribe type");
//        }
        ObserverOfStudentUnion studentDecoretor = new ObserverOfStudentUnion(student);
        studentUnion.unsubscribeSpecificNewsletter(studentDecoretor, type);
    }
}
