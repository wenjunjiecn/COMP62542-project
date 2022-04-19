package com.uom.cs.studentsystem.service.timetable;

import org.apache.tomcat.jni.Time;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class ByTimeTimetableIterator implements Iterator{
    private int cursor;
    private List<TimetableItem> list;
    @Override
    public boolean hasNext() {
        return cursor!=list.size();
    }

    @Override
    public TimetableItem next() {
        return list.get(cursor++);
    }

    public ByTimeTimetableIterator(BasicTimetable basicTimetable){
        this.cursor=0;
        this.list = basicTimetable.getActivityDetails();
        list=list.stream()
                .sorted(Comparator.comparing(TimetableItem::getDayInWeek)
                        .thenComparing(TimetableItem::getStartTimeHour)
                        .thenComparing(TimetableItem::getStartTimeMinute))
                .collect(Collectors.toList());
    }
}
