package com.uom.cs.studentsystem.service.timetable;

/**
 * @author wenjunjie
 * @version 1.0
 */
public interface Iterator {

    boolean hasNext();

    TimetableItem next();
}
