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
    @Override
    public List<TimetableItem> getActivityDetails() {
        LinkedList<TimetableItem> activity=new LinkedList<>();
        TimetableItem item = new TimetableItem(this.startTime,this.endTime,this.dayInWeek);
        item.setMessage(this.message);
        item.setType(this.type);
        activity.add(item);
        return activity;
    }

    public AdditionActivity(AdditionalActivityEntity entity){
        this.id=entity.getId();
        this.startTime=entity.getStartTime();
        this.endTime=entity.getEndTime();
        this.message=entity.getMessage();
        this.dayInWeek=entity.getDayInWeek();
    }
}
