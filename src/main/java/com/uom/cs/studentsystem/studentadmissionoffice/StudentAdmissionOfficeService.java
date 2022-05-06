package com.uom.cs.studentsystem.studentadmissionoffice;

import com.uom.cs.studentsystem.model.MessageRecordEntity;
import com.uom.cs.studentsystem.repository.MessageRecordEntityRepository;
import com.uom.cs.studentsystem.service.studentunion.newsletterTemplate.BasicNewsletter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentAdmissionOfficeService {

    @Autowired StudentAdmissionOffice studentAdmissionOffice;

    public void createAndSaveReminder(AdmissionOfficeReminder admissionOfficeReminder) {
        studentAdmissionOffice.saveReminderToDatabase(admissionOfficeReminder);
    }

}
