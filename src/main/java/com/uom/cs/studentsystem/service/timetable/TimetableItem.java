package com.uom.cs.studentsystem.service.timetable;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class TimetableItem {
    private Long id;
    private Integer dayInWeek;
    private String startTime;
    private String endTime;
    private String type;
    private String message;
    public TimetableItem(Long id, String startTime,String endTime, Integer dayInWeek){
        this.id= id;
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

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TimetableItem{" +
                "id=" + id +
                ", dayInWeek=" + dayInWeek +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
