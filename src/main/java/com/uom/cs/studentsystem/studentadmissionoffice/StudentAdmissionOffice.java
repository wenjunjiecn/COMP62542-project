package com.uom.cs.studentsystem.studentadmissionoffice;

import com.uom.cs.studentsystem.model.MessageRecordEntity;
import com.uom.cs.studentsystem.model.StudentEntity;
import com.uom.cs.studentsystem.model.StudentInboxEntity;
import com.uom.cs.studentsystem.repository.MessageRecordEntityRepository;
import com.uom.cs.studentsystem.repository.StudentEntityRepository;
import com.uom.cs.studentsystem.repository.StudentInboxEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentAdmissionOffice {
    @Autowired
    private MessageRecordEntityRepository messageRecordEntityRepository;

    @Autowired
    private StudentEntityRepository studentEntityRepository;

    @Autowired
    private StudentInboxEntityRepository studentInboxEntityRepository;

    public void saveReminderToDatabase(AdmissionOfficeReminder admissionOfficeReminder) {
        MessageRecordEntity messageRecordEntity = new MessageRecordEntity();
        messageRecordEntity.setIdNews(admissionOfficeReminder.getId_news());
        messageRecordEntity.setNewsType(admissionOfficeReminder.getNews_type());
        messageRecordEntity.setTitle(admissionOfficeReminder.getTitle());
        messageRecordEntity.setContent(admissionOfficeReminder.getContent());
        messageRecordEntity.setDate(admissionOfficeReminder.getDate());
        messageRecordEntityRepository.saveAndFlush(messageRecordEntity);
    }

    public void notifyAllPendingStudents() {
        List<MessageRecordEntity> messageRecordEntityList = messageRecordEntityRepository.findAll();
        List<StudentEntity> studentEntityList = studentEntityRepository.findAll();
        for (MessageRecordEntity messageRecordEntity:
                messageRecordEntityList) {
            for (StudentEntity studentEntity:
                    studentEntityList) {
                if (messageRecordEntity.getNewsType().equals("Admission Office") && studentEntity.getState().equals("Pending")) {
                    StudentInboxEntity studentInboxEntity = new StudentInboxEntity(studentEntity.getId(), messageRecordEntity);
                    studentInboxEntityRepository.saveAndFlush(studentInboxEntity);
                }
            }
        }
    }
}
