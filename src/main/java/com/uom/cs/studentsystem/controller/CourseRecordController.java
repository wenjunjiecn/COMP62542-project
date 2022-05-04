package com.uom.cs.studentsystem.controller;

import com.uom.cs.studentsystem.model.CourseEntity;
import com.uom.cs.studentsystem.service.CourseService;
import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.utils.ConstantUtils;
import com.uom.cs.studentsystem.vo.CourseItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Controller
public class CourseRecordController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/optionalcourse")
    public String getCoursePage(Model model,HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        if (student != null) {
            List<CourseItemVO> allCourse = courseService.getAllCourse(student.getId());
            System.out.println(allCourse);
            model.addAttribute("curriculumList", allCourse);
        }
        return "curriculum";
    }
    @RequestMapping("/add/{department}/{courseid}")
    public String addCourse(@PathVariable(value = "department") String dep, @PathVariable("courseid") String id, HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        if (student != null) {
            courseService.addCourse(student,dep,id);
        }
        return "redirect:/optionalcourse";
    }

    @RequestMapping("/remove/{department}/{courseid}")
    public String removeCourse(@PathVariable(value = "department") String dep, @PathVariable("courseid") String id, HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        if (student != null) {
            courseService.removeCourse(student,dep,id);
        }
        return "redirect:/optionalcourse";
    }
}
