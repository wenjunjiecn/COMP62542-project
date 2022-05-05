package com.uom.cs.studentsystem.controller;

import com.uom.cs.studentsystem.model.CurriculumEntity;
import com.uom.cs.studentsystem.repository.TeacherEntityRepository;
import com.uom.cs.studentsystem.service.AuthService;
import com.uom.cs.studentsystem.service.impl.CurriculumServiceImpl;
import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author yixuan
 * @version 1.0
 * @date 2022/5/2 1:50
 */

public class OldStudentSupportController {
    @Autowired
    private AuthService authService;

    @Autowired
    private TeacherEntityRepository teacherEntityRepository;


    @Autowired
    private CurriculumServiceImpl curriculumServiceImpl;


    @GetMapping("/studentSupport")
    public String getLoginPage(Model model, HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        if (student != null) {
            List<CurriculumEntity> curriculumEntityList = curriculumServiceImpl.queryCurriculumBySubject(ConstantUtils.COMPUTER_SCIENCE, null);
            model.addAttribute("curriculumList", curriculumEntityList);
            return "studentSupport";
        }
        return "studentSupportLogin";
    }

    @PostMapping("/studentSupport")
    public String login(@RequestParam(value = "id") String id, Model model, HttpServletRequest request) {
        Student student = authService.login(id);
        if (student == null) {
            model.addAttribute("error", "The id does not exist");
            return "login";
        }
        List<CurriculumEntity> curriculumEntityList = curriculumServiceImpl.queryCurriculumBySubject(ConstantUtils.COMPUTER_SCIENCE, null);
        model.addAttribute("curriculumList", curriculumEntityList);
        model.addAttribute("url", "computerScience");
        request.getSession().setAttribute(ConstantUtils.USER_SESSION_KEY, student);
        model.addAttribute("teacherList", teacherEntityRepository.findAll());
        return "studentSupport";
    }

    @GetMapping("/studentSupport/computerScience")
    public String computerScience(Model model, HttpServletRequest request) {
        List<CurriculumEntity> curriculumEntityList = curriculumServiceImpl.queryCurriculumBySubject(ConstantUtils.COMPUTER_SCIENCE, null);
        model.addAttribute("curriculumList", curriculumEntityList);
        model.addAttribute("url", "computerScience");
        model.addAttribute("teacherList", teacherEntityRepository.findAll());
        return "studentSupport";
    }


    @GetMapping("/studentSupport/mathematics")
    public String mathematics(Model model, HttpServletRequest request) {
        List<CurriculumEntity> curriculumEntityList = curriculumServiceImpl.queryCurriculumBySubject(ConstantUtils.MATHEMATICS, null);
        model.addAttribute("curriculumList", curriculumEntityList);
        model.addAttribute("url", "mathematics");
        model.addAttribute("teacherList", teacherEntityRepository.findAll());
        return "studentSupport";
    }
}
