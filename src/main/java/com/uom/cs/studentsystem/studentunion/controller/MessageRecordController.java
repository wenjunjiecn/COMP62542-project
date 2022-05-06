package com.uom.cs.studentsystem.studentunion.controller;


import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.studentunion.newsletterTemplate.BasicNewsletter;
import com.uom.cs.studentsystem.studentunion.newsletterTemplate.NewsletterFactory;
import com.uom.cs.studentsystem.studentunion.service.StudentUnionService;
import com.uom.cs.studentsystem.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MessageRecordController {

    @Autowired
    private StudentUnionService studentUnionService;

    @GetMapping("/studentunion")
    public String getAddNewsltterPage(HttpServletRequest request) {
        return "studentunion";
    }

    @PostMapping("/studentunion/addNewsletter")
    public String addAdditionalActivity(HttpServletRequest request) {
        String id_news = request.getParameter("id_news");
        String news_type = request.getParameter("news_type");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String date = request.getParameter("date");
        BasicNewsletter basicNewsletter = NewsletterFactory.getNewsletter(id_news, news_type, title, content, date);
                studentUnionService.createAndSaveNewsletter(basicNewsletter);
        return "redirect:/studentunion";
    }

    @GetMapping("/studentunion/publishNewsletter")
    public String getPublishNewsletterPage(HttpServletRequest request) {
        return "redirect:/studentunion";
    }

    @PostMapping("/studentunion/publishNewsletter")
    public String publishNewsletter(HttpServletRequest request) {
       studentUnionService.notifyAllStudents();
        return "redirect:/studentunion";
    }


}
