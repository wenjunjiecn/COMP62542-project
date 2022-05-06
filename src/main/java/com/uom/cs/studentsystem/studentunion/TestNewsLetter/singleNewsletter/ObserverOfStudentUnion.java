package com.uom.cs.studentsystem.studentunion.TestNewsLetter.singleNewsletter;

public class ObserverOfStudentUnion implements Observer{

    private String id;
    private Subject topic;
    //private List<Subject> topics;

    public ObserverOfStudentUnion(String name) {
        this.id = name;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if(msg == null){
            System.out.println(id +":: No new newsletter");
        }else
            System.out.println(id +":: Consuming newsletter::"+msg);
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic=sub;
        //this.topics.add(sub);
    }
}
