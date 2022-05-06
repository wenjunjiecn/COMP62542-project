package com.uom.cs.studentsystem.service.timetable;

import com.uom.cs.studentsystem.model.CourseEntity;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class SelectedCourse implements IActivity {
    private Long id;
    private String startTime;
    private String endTime;
    private Integer dayInWeek;
    private String message;
    private String type = "course";
    private String studentid;

    public SelectedCourse( CourseEntity courseEntity) {
        this.id=courseEntity.getId();
        this.startTime = courseEntity.getStartTime();
        this.endTime = courseEntity.getEndTime();
        this.dayInWeek = courseEntity.getDayInWeek();
        this.message = courseEntity.getCourseName();
    }

    @Override
    public List<TimetableItem> getActivityDetails() {
        LinkedList<TimetableItem> activity = new LinkedList<>();
        TimetableItem item = new TimetableItem(this.id, this.startTime, this.endTime, this.dayInWeek);
        item.setMessage(this.message);
        item.setType(this.type);
        activity.add(item);
        return activity;
    }
}
