package com.uom.cs.studentsystem.service.timetable;

import com.uom.cs.studentsystem.model.AdditionalActivityEntity;

import java.sql.Time;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class AdditionActivity implements IActivity{
    private Long id;
    private String startTime;
    private String endTime;
    private Integer dayInWeek;
    private String message;
    private String type="additional";
    private String studentid;
    @Override
    public List<TimetableItem> getActivityDetails() {
        LinkedList<TimetableItem> activity=new LinkedList<>();
        TimetableItem item = new TimetableItem(this.id,this.startTime,this.endTime,this.dayInWeek);
        item.setMessage(this.message);
        item.setType(this.type);
        activity.add(item);
        return activity;
    }

    public AdditionActivity(String startTime, String endTime, Integer dayInWeek, String message, String studentid) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayInWeek = dayInWeek;
        this.message = message;
        this.studentid = studentid;
    }

    public AdditionActivity(AdditionalActivityEntity entity){
        this.id=entity.getId();
        this.startTime=entity.getStartTime();
        this.endTime=entity.getEndTime();
        this.message=entity.getMessage();
        this.dayInWeek=entity.getDayInWeek();
        this.studentid= entity.getStudentid();
    }

    public AdditionalActivityEntity convertToEntity(){
        AdditionalActivityEntity entity= new AdditionalActivityEntity();
        entity.setId(id);
        entity.setStartTime(startTime);
        entity.setEndTime(endTime);
        entity.setMessage(message);
        entity.setDayInWeek(dayInWeek);
        entity.setStudentid(studentid);
        return entity;
    }

    public String getStudentid() {
        return studentid;
    }
}
