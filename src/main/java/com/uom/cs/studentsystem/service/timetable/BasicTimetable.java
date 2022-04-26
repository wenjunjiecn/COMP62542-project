package com.uom.cs.studentsystem.service.timetable;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class BasicTimetable implements IActivity, IterableCollection {
    private List<IActivity> activities = new LinkedList<>();

    @Override
    public List<TimetableItem> getActivityDetails() {
        List<TimetableItem> list = new LinkedList<>();
        for (IActivity activity : activities) {
            List<TimetableItem> subList = activity.getActivityDetails();
            for (TimetableItem item : subList) {
                list.add(item);
            }
        }
        return list;
    }

    public void add(IActivity activity) {
        activities.add(activity);
    }

    @Override
    public Iterator createIterator() {
        return new ByTimeTimetableIterator(this);
    }
}
