package com.uom.cs.studentsystem.controller;

import com.uom.cs.studentsystem.model.StudentEntity;
import com.uom.cs.studentsystem.service.TimetableService;
import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.service.timetable.AdditionActivity;
import com.uom.cs.studentsystem.service.timetable.IActivity;
import com.uom.cs.studentsystem.service.timetable.TimetableItem;
import com.uom.cs.studentsystem.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        if (student != null) {
            String id = student.getId();
            List<TimetableItem> basicTimetableDetails = timetableService.getBasicTimetableDetailsOrderByTime(id);
            System.out.println("this is basictimetabledetails"+basicTimetableDetails);
            Map<Integer,List<TimetableItem>> timetableMapByDayInWeek=new HashMap<>();
            timetableMapByDayInWeek.put(1,new ArrayList<>());
            timetableMapByDayInWeek.put(2,new ArrayList<>());
            timetableMapByDayInWeek.put(3,new ArrayList<>());
            timetableMapByDayInWeek.put(4,new ArrayList<>());
            timetableMapByDayInWeek.put(5,new ArrayList<>());
            timetableMapByDayInWeek.put(6,new ArrayList<>());
            timetableMapByDayInWeek.put(7,new ArrayList<>());
            for (TimetableItem item : basicTimetableDetails) {
                timetableMapByDayInWeek.get(item.getDayInWeek()).add(item);
            }

            model.addAttribute("Monday",timetableMapByDayInWeek.get(1));
            model.addAttribute("Tuesday",timetableMapByDayInWeek.get(2));
            model.addAttribute("Wednesday",timetableMapByDayInWeek.get(3));
            model.addAttribute("Thursday",timetableMapByDayInWeek.get(4));
            model.addAttribute("Friday",timetableMapByDayInWeek.get(5));
            model.addAttribute("Saturday",timetableMapByDayInWeek.get(6));
            model.addAttribute("Sunday",timetableMapByDayInWeek.get(6));
//            System.out.println(timetableMapByDayInWeek);
        }
        return "timetable";
    }

    @PostMapping("/timetable/add")
    public String addAdditionalActivity(@RequestBody AdditionActivity activity,HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        if(!student.getId().equals(activity.getStudentid())){
            return "403";
        }
        timetableService.addAdditionalActivity(activity);
        return "redirect:/timetable";
    }

    @PostMapping("/timetable/delete/{id}")
    public String deleteAdditionalActivity(@PathVariable(name = "id") String messageId,HttpServletRequest request){
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        boolean isSuccess = timetableService.removeAdditionalActivity(student, messageId);
        if(!isSuccess){
            return "403";
        }
        return "redirect:/timetable";
    }
}
