package com.uom.cs.studentsystem.service.timetable;

/**
 * @author wenjunjie
 * @version 1.0
 */
public interface IAdditionalActivityBuilder {
     IAdditionalActivityBuilder setStartTime(String startTime);
     IAdditionalActivityBuilder setEndTime(String endTime);
     IAdditionalActivityBuilder setDayInWeek(Integer dayInWeek);
     IAdditionalActivityBuilder setMessage(String message);
     IAdditionalActivityBuilder setStudentid(String studentid);
     AdditionActivity build();

}
