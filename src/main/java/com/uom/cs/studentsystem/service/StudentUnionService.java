package com.uom.cs.studentsystem.service;

import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.service.studentunion.ObserverOfStudentUnion;
import com.uom.cs.studentsystem.service.studentunion.StudentUnion;
import com.uom.cs.studentsystem.service.studentunion.newsletterTemplate.BasicNewsletter;
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

    public void notifyAllStudents() {
        studentUnion.notifyAllStudents();
    }

    public String getSubscribeStatus(String id, String type) {
        if (studentUnion.getSubscribeStatus(id, type)) {
            return "subscribe";
        } else {
            return "unsubscribe";
        }
    }

    public void subscribeNewsletter(Student student, String type) {
        ObserverOfStudentUnion studentDecorator = new ObserverOfStudentUnion(student);
        studentUnion.register(studentDecorator);
        studentUnion.subscribeSpecificNewsletter(studentDecorator, type);

    }

    public void unsubscribeNewsletter(Student student, String type) {
        ObserverOfStudentUnion studentDecoretor = new ObserverOfStudentUnion(student);
        studentUnion.unsubscribeSpecificNewsletter(studentDecoretor, type);
    }

    public void createAndSaveNewsletter(BasicNewsletter basicNewsletter) {
        studentUnion.saveNewsletterToDatabase(basicNewsletter);
    }
}
