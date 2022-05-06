package com.uom.cs.studentsystem.studentunion.TestNewsLetter.multipleNewsletter;

import com.uom.cs.studentsystem.studentunion.TestNewsLetter.multipleNewsletter.newsletter.AcademicNewsletter;
import com.uom.cs.studentsystem.studentunion.TestNewsLetter.multipleNewsletter.newsletter.BasicNewsletter;
import com.uom.cs.studentsystem.studentunion.TestNewsLetter.multipleNewsletter.newsletter.SportsNewsletter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentUnion implements Subject {
    private static final StudentUnion instance = new StudentUnion();
    private List<Observer> observers;
    private String message;
    private boolean changed;
    private final Object MUTEX= new Object();

    private HashMap<BasicNewsletter, HashMap<String, Observer>> observerMap;


    //private constructor to avoid client applications to use constructor
    private StudentUnion(){
        this.observers = new ArrayList<>();
        this.message = "A newsletter from student union";
        this.changed = true; //测试时用
        this.observerMap = new HashMap<>();
        this.observerMap.put(AcademicNewsletter.getInstance(), new HashMap<>());
        this.observerMap.put(SportsNewsletter.getInstance(), new HashMap<>());
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

    //没用
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

    //没用
    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
        //这里应该返回一个列表的message,不
    }

    @Override
    public void registerSpecificNewsletter(Observer obj, String type) {
        if (type.equals("AcademicNewsletter")) {
            HashMap<String, Observer> tmp = this.observerMap.get(AcademicNewsletter.getInstance());
            tmp.put(obj.studentId(),obj);
            this.observerMap.put(AcademicNewsletter.getInstance(), tmp);
        } else if (type.equals("SportsNewsletter")) {
            HashMap<String, Observer> tmp = this.observerMap.get(SportsNewsletter.getInstance());
            tmp.put(obj.studentId(),obj);
            this.observerMap.put(SportsNewsletter.getInstance(), tmp);
        }
    }

    //method to post message to the topic
    public void postMessage(String msg){
        System.out.println("Message Posted to Newsletter:"+msg);
        this.message=msg;
        this.changed=true;
        notifyObservers();
    }

    public void postAllMessage() {
        System.out.println("Message Posted to AcademicNewsletter:"+"Academic!!!");
        this.message="Academic *******";
        this.changed=true;
        notifyObserversAcademic();
        System.out.println("Message Posted to SportsNewsletter:"+"Sports!!!");
        this.message="Sports *******";
        this.changed=true;
        notifyObserversSports();
    }

    //下面可以用方法重载简化
    public void notifyObserversAcademic() {
        List<Observer> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            //observersLocal = new ArrayList<>(this.observers);
            observersLocal = new ArrayList<>(this.observerMap.get(AcademicNewsletter.getInstance()).values());
            this.changed=false;
        }
        for (Observer obj : observersLocal) {
            obj.update();
        }
    }

    public void notifyObserversSports() {
        List<Observer> observersLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX) {
            if (!changed)
                return;
            //observersLocal = new ArrayList<>(this.observers);
            observersLocal = new ArrayList<>(this.observerMap.get(SportsNewsletter.getInstance()).values());
            this.changed=false;
        }
        for (Observer obj : observersLocal) {
            obj.update();
        }
    }
}
