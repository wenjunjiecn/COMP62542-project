package com.uom.cs.studentsystem.controller;

import com.uom.cs.studentsystem.service.StudentService;
import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * StudentDetailController is a controller specifically designed
 * to display student information pages
 *
 * @version 1.0
 */
@Controller
public class StudentDetailController {
    @Autowired
    StudentService studentService;

    /**
     * This is the user home page, used to display
     * the user's personal information, including
     * registration status
     */
    @RequestMapping("/")
    public String getHomePage(Model model, HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        if (student != null) {
            model.addAttribute("id", student.getId());
            model.addAttribute("name", student.getName());
            model.addAttribute("state", studentService.getRegisterStatus(student.getId()));
        }
        return "index";
    }
}
