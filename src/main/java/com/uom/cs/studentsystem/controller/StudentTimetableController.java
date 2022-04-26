package com.uom.cs.studentsystem.controller;

import com.uom.cs.studentsystem.service.TimetableService;
import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.service.timetable.AdditionActivity;
import com.uom.cs.studentsystem.service.timetable.TimetableItem;
import com.uom.cs.studentsystem.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Controller
public class StudentTimetableController {
    @Autowired
    TimetableService timetableService;

    @RequestMapping("/timetable")
    public String getTimetablePage(Model model, HttpServletRequest request) {
        Student student = getStudent(request);
        if (student == null) return "403";
        String id = student.getId();
        List<TimetableItem> basicTimetableDetails = timetableService.getBasicTimetableDetailsOrderByTime(id);
        System.out.println("this is basictimetabledetails" + basicTimetableDetails);
        Map<Integer, List<TimetableItem>> timetableMapByDayInWeek = new HashMap<>();
        timetableMapByDayInWeek.put(1, new ArrayList<>());
        timetableMapByDayInWeek.put(2, new ArrayList<>());
        timetableMapByDayInWeek.put(3, new ArrayList<>());
        timetableMapByDayInWeek.put(4, new ArrayList<>());
        timetableMapByDayInWeek.put(5, new ArrayList<>());
        timetableMapByDayInWeek.put(6, new ArrayList<>());
        timetableMapByDayInWeek.put(7, new ArrayList<>());
        for (TimetableItem item : basicTimetableDetails) {
            timetableMapByDayInWeek.get(item.getDayInWeek()).add(item);
        }

        model.addAttribute("Monday", timetableMapByDayInWeek.get(1));
        model.addAttribute("Tuesday", timetableMapByDayInWeek.get(2));
        model.addAttribute("Wednesday", timetableMapByDayInWeek.get(3));
        model.addAttribute("Thursday", timetableMapByDayInWeek.get(4));
        model.addAttribute("Friday", timetableMapByDayInWeek.get(5));
        model.addAttribute("Saturday", timetableMapByDayInWeek.get(6));
        model.addAttribute("Sunday", timetableMapByDayInWeek.get(6));
//            System.out.println(timetableMapByDayInWeek);
        return "timetable";
    }


    @GetMapping("/timetable/add")
    public String getAddActivityPage(HttpServletRequest request) {
        Student student = getStudent(request);
        if (student == null) return "403";
        return "addActivity";
    }

    @PostMapping("/timetable/add")
    public String addAdditionalActivity(HttpServletRequest request) {
        Student student = getStudent(request);
        if (student == null) return "403";
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String message = request.getParameter("message");
        Integer dayInWeek = Integer.parseInt(request.getParameter("dayInWeek"));
        String stuId = student.getId();
        AdditionActivity activity = new AdditionActivity(startTime, endTime, dayInWeek, message, stuId);

        timetableService.addAdditionalActivity(activity);
        return "redirect:/timetable";
    }

    /**
     * Delete additional activities for students via message id
     *
     * @param messageId
     * @param request
     */
    @PostMapping("/timetable/delete/{id}")
    public String deleteAdditionalActivity(@PathVariable(name = "id") String messageId, HttpServletRequest request) {
        Student student = getStudent(request);
        if (student == null) return "403";
        boolean isSuccess = timetableService.removeAdditionalActivity(student, messageId);
        if (!isSuccess) {
            return "403";
        }
        return "redirect:/timetable";
    }

    /**
     * Get the student object in the session, if there is a student object
     * and the object has permission to access the timetable function then
     * return the object, otherwise return null
     *
     * @param request
     * @return student
     */
    private Student getStudent(HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        if (student == null || !student.hasTimeTablePermission()) {
            return null;
        }
        return student;
    }

}
