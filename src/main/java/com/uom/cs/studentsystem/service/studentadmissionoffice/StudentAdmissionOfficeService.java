package com.uom.cs.studentsystem.service.studentadmissionoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentAdmissionOfficeService {

    @Autowired StudentAdmissionOffice studentAdmissionOffice;

    public void createAndSaveReminder(AdmissionOfficeReminder admissionOfficeReminder) {
        studentAdmissionOffice.saveReminderToDatabase(admissionOfficeReminder);
    }

}
