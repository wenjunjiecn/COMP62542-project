package com.uom.cs.studentsystem.service.studentunion.TestNewsLetter.singleNewsletter;

import java.util.ArrayList;
import java.util.List;

public class StudentUnion implements Subject{
    private static final StudentUnion instance = new StudentUnion();
    private List<Observer> observers;
    private String message;
    private boolean changed;
    private final Object MUTEX= new Object();
    //private constructor to avoid client applications to use constructor
    private StudentUnion(){
        this.observers = new ArrayList<>();
        this.message = "A newsletter from student union";
        this.changed = true; //测试时用
    }

    public static StudentUnion getInstance(){
        return instance;
    }

    @Override
    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null ObserverOfStudentUnion");
        synchronized (MUTEX) {
            if(!observers.contains(obj)) observers.add(obj);
        }
    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX) {
            observers.remove(obj);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.changed=false;
        }
        for (Observer obj : observersLocal) {
            obj.update();
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    //method to post message to the topic
    public void postMessage(String msg){
        System.out.println("Message Posted to Newsletter:"+msg);
        this.message=msg;
        this.changed=true;
        notifyObservers();
    }
}
