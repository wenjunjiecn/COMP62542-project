package com.uom.cs.studentsystem.inbox.controller;

import com.uom.cs.studentsystem.inbox.model.StudentInboxEntity;
import com.uom.cs.studentsystem.inbox.service.InboxService;
import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class InboxController {

    @Autowired
    private InboxService inboxService;

    @GetMapping("/inboxHome")
    public String getInboxHomePage(Model model, HttpServletRequest request) {
        Student student = getStudent(request);
        if (student == null) return "403";
        List<StudentInboxEntity> studentInboxEntityList = inboxService.getInboxEntityByStudentId(student.getId());
        model.addAttribute("inboxList", studentInboxEntityList);
        return "inboxHome";
    }

    @GetMapping("/inboxHome/MessageDetail/{newsid}")
    public String getMessageDetail(@PathVariable String newsid, HttpServletRequest request, Model model) {
        Student student = getStudent(request);
        if (student == null) return "403";
        StudentInboxEntity studentInboxEntity = inboxService.getInboxEntityByStudentIdByidnews(student.getId(), newsid);
        //System.out.println(studentInboxEntity);
        model.addAttribute("message", studentInboxEntity);
        return "inboxMessage";
    }

    private Student getStudent(HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        if (student == null || !student.hasTimeTablePermission()) {
            return null;
        }
        return student;
    }
}
