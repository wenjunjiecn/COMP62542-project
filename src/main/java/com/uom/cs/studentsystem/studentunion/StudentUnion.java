package com.uom.cs.studentsystem.studentunion;


import com.uom.cs.studentsystem.studentunion.model.AcademicNewsletterEntity;
import com.uom.cs.studentsystem.studentunion.model.SocialNewsletterEntity;
import com.uom.cs.studentsystem.studentunion.model.SportsNewsletterEntity;
import com.uom.cs.studentsystem.studentunion.newsletter.AcademicNewsletter;
import com.uom.cs.studentsystem.studentunion.newsletter.BasicNewsletter;
import com.uom.cs.studentsystem.studentunion.newsletter.SocialNewsletter;
import com.uom.cs.studentsystem.studentunion.newsletter.SportsNewsletter;
import com.uom.cs.studentsystem.studentunion.repository.AcademicNewsletterEntityRepository;
import com.uom.cs.studentsystem.studentunion.repository.SocialNewsletterEntityRepository;
import com.uom.cs.studentsystem.studentunion.repository.SportsNewsletterEntityRepository;
import com.uom.cs.studentsystem.studentunion.service.StudentUnionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class StudentUnion implements Subject, Serializable {
    private static final long serialVersionUID = 6687929992161255473L;
    private static final StudentUnion instance = new StudentUnion();
    private List<Observer> observers;
    private String message;
    private boolean changed;
    private final Object MUTEX= new Object();

    @Autowired
    private SportsNewsletterEntityRepository sportsNewsletterEntityRepository;

    @Autowired
    private AcademicNewsletterEntityRepository academicNewsletterEntityRepository;

    @Autowired
    private SocialNewsletterEntityRepository socialNewsletterEntityRepository;

    //private HashMap<BasicNewsletter, HashMap<String, Observer>> observerMap;
//    @Autowired
//    private StudentUnionService studentUnionService;

    //private constructor to avoid client applications to use constructor
    private StudentUnion(){
        this.observers = new ArrayList<>();
        this.message = "A newsletter from student union";
        this.changed = true; //测试时用
        //this.observerMap = new HashMap<>();
        //this.observerMap.put(AcademicNewsletter.getInstance(), new HashMap<>());
        //this.observerMap.put(SportsNewsletter.getInstance(), new HashMap<>());
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

    public String getSubscribeStatus(String id, String type) {
        if (type.equals("academic")) {
            AcademicNewsletterEntity academicNewsletterEntity = academicNewsletterEntityRepository.getById(id);
            return academicNewsletterEntity.getState();
        } else if (type.equals("sports")) {
            SportsNewsletterEntity sportsNewsletterEntity = sportsNewsletterEntityRepository.getById(id);
            return sportsNewsletterEntity.getState();
        } else if (type.equals("social")) {
            SocialNewsletterEntity socialNewsletterEntity = socialNewsletterEntityRepository.getById(id);
            return socialNewsletterEntity.getState();
        } else {
            System.out.println("illegal subscribe type");
            return "Error";
        }
    }

    @Override
    public void subscribeSpecificNewsletter(Observer obj, String type) {
        //studentUnionService.subscribeNewsletter(obj.studentId(), type);
        //AcademicNewsletterEntity academicNewsletterEntity = new AcademicNewsletterEntity();
        //academicNewsletterEntity.setId(obj.studentId());
        //academicNewsletterEntity.setState("subscribe");
        //academicNewsletterEntityRepository.saveAndFlush(academicNewsletterEntity);
        if (type.equals("academic")) {
            AcademicNewsletterEntity academicNewsletterEntity = new AcademicNewsletterEntity();
            academicNewsletterEntity.setId(obj.studentId());
            academicNewsletterEntity.setState("subscribe");
            academicNewsletterEntityRepository.saveAndFlush(academicNewsletterEntity);
        } else if (type.equals("sports")) {
            SportsNewsletterEntity sportsNewsletterEntity = new SportsNewsletterEntity();
            sportsNewsletterEntity.setId(obj.studentId());
            sportsNewsletterEntity.setState("subscribe");
            sportsNewsletterEntityRepository.saveAndFlush(sportsNewsletterEntity);
        } else if (type.equals("social")) {
            SocialNewsletterEntity socialNewsletterEntity = new SocialNewsletterEntity();
            socialNewsletterEntity.setId(obj.studentId());
            socialNewsletterEntity.setState("subscribe");
            socialNewsletterEntityRepository.saveAndFlush(socialNewsletterEntity);
        } else {
            System.out.println("illegal subscribe type");
        }
    }

    @Override
    public void unsubscribeSpecificNewsletter(Observer obj, String type) {
        //studentUnionService.unsubscribeNewsletter(obj.studentId(), type);
        if (type.equals("academic")) {
            academicNewsletterEntityRepository.deleteById(obj.studentId());
        } else if (type.equals("sports")) {
            sportsNewsletterEntityRepository.deleteById(obj.studentId());
        } else {
            System.out.println("illegal unsubscribe type");
        }
    }
    /*
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
    */


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
            //observersLocal = new ArrayList<>(this.observerMap.get(AcademicNewsletter.getInstance()).values());
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
            //observersLocal = new ArrayList<>(this.observerMap.get(SportsNewsletter.getInstance()).values());
            this.changed=false;
        }
        for (Observer obj : observersLocal) {
            obj.update();
        }
    }
}
