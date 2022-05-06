package com.uom.cs.studentsystem.studentadmissionoffice;

import com.uom.cs.studentsystem.model.MessageRecordEntity;
import com.uom.cs.studentsystem.repository.MessageRecordEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentAdmissionOffice {
    @Autowired
    private MessageRecordEntityRepository messageRecordEntityRepository;

    public void saveReminderToDatabase(AdmissionOfficeReminder admissionOfficeReminder) {
        MessageRecordEntity messageRecordEntity = new MessageRecordEntity();
        messageRecordEntity.setIdNews(admissionOfficeReminder.getId_news());
        messageRecordEntity.setNewsType(admissionOfficeReminder.getNews_type());
        messageRecordEntity.setTitle(admissionOfficeReminder.getTitle());
        messageRecordEntity.setContent(admissionOfficeReminder.getContent());
        messageRecordEntity.setDate(admissionOfficeReminder.getDate());
        messageRecordEntityRepository.saveAndFlush(messageRecordEntity);
    }
}
