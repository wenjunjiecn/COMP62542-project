package com.uom.cs.studentsystem.service.studentunion.TestNewsLetter.multipleNewsletter;


public interface Observer {

    //method to update the observer, used by subject
    public void update();

    //attach with subject to observe
    public void setSubject(Subject sub);

    public void setNewsletter(String type);

    public String studentId();
}
