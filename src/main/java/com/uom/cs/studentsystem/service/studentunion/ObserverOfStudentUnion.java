package com.uom.cs.studentsystem.service.studentunion;


import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.service.status.StudentDecorator;

import java.io.Serializable;

public class ObserverOfStudentUnion extends StudentDecorator implements Observer, Serializable {

    //private Student student;
    //private String id;
    private Subject topic;
    //private List<Subject> topics; 不对，topic只有一个，剩下的在studentUnion里添加就可

    public ObserverOfStudentUnion(Student student) {
        super(student);
        //this.student=student;
        //this.id = student.getId();
        this.topic = StudentUnion.getInstance();
    }

    @Override
    public void update() {
        //根据controller层改写
        String msg = (String) topic.getUpdate(this);
        //这里应该接收一个列表的msg
        if(msg == null){
            System.out.println(this.studentId() +":: No new newsletter");
        }else
            System.out.println(this.studentId() +":: Consuming newsletter::"+msg);
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic=sub;
        //this.topics.add(sub);
    }

    @Override
    public void subscribeNewsletter(String type) {
        this.topic.subscribeSpecificNewsletter(this, type);
    }

    @Override
    public void unsubscribeNewsletter(String type) {
        this.topic.unsubscribeSpecificNewsletter(this, type);
    }

    /*public void setNewsletter(String type) {
        return; //这里不需要操作
    }
    */

    @Override
    public String studentId() {
        return this.student.getId();
    }
}
