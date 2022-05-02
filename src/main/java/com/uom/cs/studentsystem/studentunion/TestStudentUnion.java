package com.uom.cs.studentsystem.studentunion;

public class TestStudentUnion {
    public static void main(String[] args) {
        //create subject
        StudentUnion topic = StudentUnion.getInstance();

        //create observers
        Observer obj1 = new ObserverOfStudentUnion("Obj1");
        Observer obj2 = new ObserverOfStudentUnion("Obj2");
        Observer obj3 = new ObserverOfStudentUnion("Obj3");

        //register observers to the subject
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        //attach observer to subject
        obj1.setSubject(topic);
        obj2.setSubject(topic);
        obj3.setSubject(topic);

        //check if any update is available
        obj1.update();

        //now send message to subject
        topic.postMessage("New Message from newsletter");
    }
}
