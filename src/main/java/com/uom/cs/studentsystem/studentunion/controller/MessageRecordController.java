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
//        Student student = getStudent(request);
//        if (student == null) return "403";
        return "addNewsletter";
    }

    @PostMapping("/addNewsletter")
    public String addAdditionalActivity(HttpServletRequest request) {
//        Student student = getStudent(request);
//        if (student == null) return "403";
//        String startTime = request.getParameter("startTime");
//        String endTime = request.getParameter("endTime");
//        String message = request.getParameter("message");
//        Integer dayInWeek = Integer.parseInt(request.getParameter("dayInWeek"));
//        String stuId = student.getId();
//        AdditionActivity activity = new AdditionActivity(startTime, endTime, dayInWeek, message, stuId);
        String id_news = request.getParameter("id_news");
        String news_type = request.getParameter("news_type");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String date = request.getParameter("date");
        BasicNewsletter basicNewsletter = NewsletterFactory.getNewsletter(id_news, news_type, title, content, date);
        //System.out.println(content);
        studentUnionService.createAndSaveNewsletter(basicNewsletter);
        return "redirect:/studentunion";
    }

    @GetMapping("/publishNewsletter")
    public String getPublishNewsletterPage(HttpServletRequest request) {
//        Student student = getStudent(request);
//        if (student == null) return "403";
        return "/publishNewsletter";
    }

    @PostMapping("/publishNewsletter")
    public String publishNewsletter(HttpServletRequest request) {
//        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        studentUnionService.notifyAllStudents();
        return "redirect:/publishNewsletter";
    }

//    private Student getStudent(HttpServletRequest request) {
//        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
//        if (student == null || !student.hasTimeTablePermission()) {
//            return null;
//        }
//        return student;
//    }
}
