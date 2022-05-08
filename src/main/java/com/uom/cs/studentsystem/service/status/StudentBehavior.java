package com.uom.cs.studentsystem.service.status;

import com.uom.cs.studentsystem.service.studentunion.Subject;

public interface StudentBehavior {

    public void setSubject(Subject sub);

    public void subscribeNewsletter(String type);

    public void unsubscribeNewsletter(String type);
}
