package com.uom.cs.studentsystem.service.timetable;

import java.util.regex.Pattern;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class BasicAdditionActivityBuilder implements IAdditionalActivityBuilder{
    private AdditionActivity activity=new AdditionActivity();

    @Override
    public BasicAdditionActivityBuilder setStartTime(String startTime) {
        String TIME24HOURS_PATTERN =
                "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern compile = Pattern.compile(TIME24HOURS_PATTERN);
        if(!compile.matcher(startTime).matches()){
            throw new RuntimeException("The start time format is wrong:"+startTime);
        }
        activity.setStartTime(startTime);
        return this;
    }

    @Override
    public BasicAdditionActivityBuilder setEndTime(String endTime) {
        String TIME24HOURS_PATTERN =
                "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        Pattern compile = Pattern.compile(TIME24HOURS_PATTERN);
        if(!compile.matcher(endTime).matches()){
            throw new RuntimeException("The start time format is wrong:"+endTime);
        }
        System.out.println("start time is being check");
        activity.setEndTime(endTime);
        return this;
    }

    @Override
    public BasicAdditionActivityBuilder setDayInWeek(Integer dayInWeek) {
        if(!(dayInWeek>=1&&dayInWeek<=7)){
            throw new RuntimeException("Day in Week should between [1-7]" );
        }
        activity.setDayInWeek(dayInWeek);
        return this;
    }

    @Override
    public BasicAdditionActivityBuilder setMessage(String message) {
        activity.setMessage(message);
        return this;
    }

    @Override
    public BasicAdditionActivityBuilder setStudentid(String studentid) {
        activity.setStudentid(studentid);
        return this;
    }

    @Override
    public AdditionActivity build() {
        //check if all required field have been set
        if(activity.getStartTime()==null||activity.getEndTime()==null||activity.getDayInWeek()==null||activity.getMessage()==null||activity.getStudentid()==null){
            throw new RuntimeException("All requirement field should be set");
        }
        System.out.println("required field is set");
        return activity;
    }
}
