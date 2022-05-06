package com.uom.cs.studentsystem.controller;

import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.service.StudentUnionService;
import com.uom.cs.studentsystem.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentunionController {
    @Autowired
    private StudentUnionService studentUnionService;


    @GetMapping("/subscribeCenter")
    public String getLoginPage(Model model, HttpServletRequest request) {
        Student student = getStudent(request);
        if (student == null) return "403";
        model.addAttribute("academic", studentUnionService.getSubscribeStatus(student.getId(), "academic"));
        model.addAttribute("sports", studentUnionService.getSubscribeStatus(student.getId(), "sports"));
        model.addAttribute("social", studentUnionService.getSubscribeStatus(student.getId(), "social"));
        return "subscribeCenter";
    }

    @PostMapping("/subscribeCenter/subscribeAcademic")
    public String subscribeAcademic( Model model, HttpServletRequest request) {
        Student student = getStudent(request);
        if (student == null) return "403";
        studentUnionService.subscribeNewsletter(student, "academic");
        return "redirect:/subscribeCenter";
    }

    @PostMapping("/subscribeCenter/unsubscribeAcademic")
    public String unsubscribeAcademic(HttpServletRequest request) {
        Student student = getStudent(request);
        if (student == null) return "403";
        studentUnionService.unsubscribeNewsletter(student, "academic");
        return "redirect:/subscribeCenter";
    }

    @PostMapping("/subscribeCenter/subscribeSports")
    public String subscribeSports( Model model, HttpServletRequest request) {
        Student student = getStudent(request);
        if (student == null) return "403";
        studentUnionService.subscribeNewsletter(student, "sports");
        return "redirect:/subscribeCenter";
    }

    @PostMapping("/subscribeCenter/unsubscribeSports")
    public String unsubscribeSports(HttpServletRequest request) {
        Student student = getStudent(request);
        studentUnionService.unsubscribeNewsletter(student, "sports");
        return "redirect:/subscribeCenter";
    }

    @PostMapping("/subscribeCenter/subscribeSocial")
    public String subscribeSocial( Model model, HttpServletRequest request) {
        Student student = getStudent(request);
        if (student == null) return "403";
        studentUnionService.subscribeNewsletter(student, "social");
        return "redirect:/subscribeCenter";
    }

    @PostMapping("/subscribeCenter/unsubscribeSocial")
    public String unsubscribeSocial(HttpServletRequest request) {
        Student student = getStudent(request);
        if (student == null) return "403";
        studentUnionService.unsubscribeNewsletter(student, "social");
        return "redirect:/subscribeCenter";
    }

    private Student getStudent(HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        if (student == null || !student.hasStudentUnionPermission()) {
            return null;
        }
        return student;
    }
}