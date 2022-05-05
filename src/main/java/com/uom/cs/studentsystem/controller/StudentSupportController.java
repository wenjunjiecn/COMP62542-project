package com.uom.cs.studentsystem.controller;


import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.service.studentsupport.StudentSupport;
import com.uom.cs.studentsystem.service.studentsupport.StudentSupportServices;
import com.uom.cs.studentsystem.utils.ConstantUtils;
import com.uom.cs.studentsystem.vo.CourseItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Controller
public class StudentSupportController {
    @Autowired
    StudentSupportServices studentSupportServices;

    @GetMapping("/studentsupport")
    public String getStudentSupportPage(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute(ConstantUtils.STUDENT_SUPPORT)==null){
            StudentSupport studentSupport = new StudentSupport(null);
            request.getSession().setAttribute(ConstantUtils.STUDENT_SUPPORT,studentSupport);
        }

        return "studentsupportpage";
    }

    @GetMapping("/studentsupport/query/{studentid}")
    public String bindStudent(@PathVariable("studentid") String studentid, HttpServletRequest request, Model model){
        StudentSupport studentSupport=(StudentSupport) request.getSession().getAttribute(ConstantUtils.STUDENT_SUPPORT);
        Student student=studentSupportServices.createStudent(studentid);
        studentSupport.setStudent(student);
        request.getSession().setAttribute(ConstantUtils.STUDENT_SUPPORT,studentSupport);
        List<CourseItemVO> courseList = studentSupportServices.getCourseList(student);

        model.addAttribute("student",student);
        model.addAttribute("curriculumList",courseList);
        System.out.println(courseList);
        return "studentsupportlist";
    }

    @RequestMapping("/studentsupport/add/{courseid}")
    public String addCourseForStudent(@PathVariable String courseid, HttpServletRequest request){
        StudentSupport studentSupport=(StudentSupport) request.getSession().getAttribute(ConstantUtils.STUDENT_SUPPORT);
        Student student = studentSupport.getStudent();
        System.out.println("+++"+student);
        studentSupportServices.addCourseForStudent(studentSupport,Long.parseLong(courseid));
        return "redirect:/studentsupport/query/"+student.getId();
    }

    @RequestMapping("/studentsupport/remove/{courseid}")
    public String removeCourseForStudent(@PathVariable String courseid, HttpServletRequest request){
        StudentSupport studentSupport=(StudentSupport) request.getSession().getAttribute(ConstantUtils.STUDENT_SUPPORT);
        Student student = studentSupport.getStudent();
        System.out.println("+++"+student);
        studentSupportServices.removeCourseForStudent(studentSupport,Long.parseLong(courseid));
        return "redirect:/studentsupport/query/"+student.getId();
    }


}
