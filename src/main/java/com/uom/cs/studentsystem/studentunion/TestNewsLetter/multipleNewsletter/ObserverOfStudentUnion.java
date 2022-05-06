package com.uom.cs.studentsystem.studentunion.TestNewsLetter.multipleNewsletter;


public class ObserverOfStudentUnion implements Observer {

    private String id;
    private Subject topic;
    //private List<Subject> topics; 不对，topic只有一个，剩下的在studentUnion里添加就可

    public ObserverOfStudentUnion(String name) {
        this.id = name;
    }

    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        //这里应该接收一个列表的msg
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

    @Override
    public void setNewsletter(String type) {
        return; //这里不需要操作
    }

    @Override
    public String studentId() {
        return this.id;
    }
}
