package com.uom.cs.studentsystem.service.timetable;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class TimetableItem {
    private Integer dayInWeek;
    private String startTime;
    private String endTime;
    private String type;
    private String message;
    public TimetableItem(String startTime,String endTime, Integer dayInWeek){
        this.dayInWeek=dayInWeek;
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDayInWeek() {
        return dayInWeek;
    }

    public Integer getStartTimeHour(){
        return Integer.parseInt(startTime.split(":")[0]);
    }

    public Integer getStartTimeMinute(){
        return Integer.parseInt(startTime.split(":")[1]);
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TimetableItem{" +
                "dayInWeek=" + dayInWeek +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
