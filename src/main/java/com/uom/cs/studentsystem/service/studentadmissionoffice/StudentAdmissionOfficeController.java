package com.uom.cs.studentsystem.service.studentadmissionoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentAdmissionOfficeController {

    @Autowired StudentAdmissionOffice studentAdmissionOffice;

    @GetMapping("/studentadmissionoffice")
    public String getAddReminderPage(HttpServletRequest request) {
        return "studentadmissionoffice";
    }

    @PostMapping("/studentadmissionoffice/addReminder")
    public String addAdditionalActivity(HttpServletRequest request) {
        String id_news = request.getParameter("id_news");
        String news_type = request.getParameter("news_type");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String date = request.getParameter("date");
        //BasicNewsletter basicNewsletter = NewsletterFactory.getNewsletter(id_news, news_type, title, content, date);
        //studentUnionService.createAndSaveNewsletter(basicNewsletter);
        AdmissionOfficeReminder admissionOfficeReminder = new AdmissionOfficeReminder(id_news, news_type, title, content, date);
        studentAdmissionOffice.saveReminderToDatabase(admissionOfficeReminder);
        return "redirect:/studentadmissionoffice";
    }

    @GetMapping("/studentadmissionoffice/publishReminder")
    public String getPublishReminderPage(HttpServletRequest request) {
        return "redirect:/studentadmissionoffice";
    }

    @PostMapping("/studentadmissionoffice/publishReminder")
    public String publishReminder(HttpServletRequest request) {
        studentAdmissionOffice.notifyAllPendingStudents();
        return "redirect:/studentadmissionoffice";
    }
}