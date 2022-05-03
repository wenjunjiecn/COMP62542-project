package com.uom.cs.studentsystem.studentunion.controller;

import com.uom.cs.studentsystem.service.AuthService;
import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.studentunion.service.StudentUnionService;
import com.uom.cs.studentsystem.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentunionController {
    @Autowired
    private StudentUnionService studentUnionService;


    @GetMapping("/studentunion")
    public String getLoginPage(Model model) {

        return "studentunion";
    }

    @PostMapping("/studentunion/subscribeAcademic")
    public String subscribeAcademic( Model model, HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        studentUnionService.subscribeNewsletter(student, "academic");
        return "redirect:/studentunion";
    }

    @PostMapping("/studentunion/unsubscribeAcademic")
    public String unsubscribeAcademic(HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        studentUnionService.unsubscribeNewsletter(student, "academic");
        return "redirect:/studentunion";
    }

    @PostMapping("/studentunion/subscribeSports")
    public String subscribeSports( Model model, HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        studentUnionService.subscribeNewsletter(student, "sports");
        return "redirect:/studentunion";
    }

    @PostMapping("/studentunion/unsubscribeSports")
    public String unsubscribeSports(HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        studentUnionService.unsubscribeNewsletter(student, "sports");
        return "redirect:/studentunion";
    }

    @PostMapping("/studentunion/subscribeSocial")
    public String subscribeSocial( Model model, HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        studentUnionService.subscribeNewsletter(student, "social");
        return "redirect:/studentunion";
    }

    @PostMapping("/studentunion/unsubscribeSocial")
    public String unsubscribeSocial(HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        studentUnionService.unsubscribeNewsletter(student, "social");
        return "redirect:/studentunion";
    }
}