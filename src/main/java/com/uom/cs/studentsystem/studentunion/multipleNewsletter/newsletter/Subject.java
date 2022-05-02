package com.uom.cs.studentsystem.studentunion.multipleNewsletter.newsletter;


public interface Subject {

    //methods to register and unregister observers
    public void register(Observer obj);
    public void unregister(Observer obj);

    //method to notify observers of change
    public void notifyObservers();

    //method to get updates from subject
    public Object getUpdate(Observer obj);

    //method to set type of Newsletter
    public void registerSpecificNewsletter(Observer obj, String type);
}
