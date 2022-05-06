package com.uom.cs.studentsystem.studentunion.TestNewsLetter.singleNewsletter;

public interface Observer {

    //method to update the observer, used by subject
    public void update();

    //attach with subject to observe
    public void setSubject(Subject sub);
}
