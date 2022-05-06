package com.uom.cs.studentsystem.service.studentunion;


import com.uom.cs.studentsystem.model.StudentInboxEntity;
import com.uom.cs.studentsystem.repository.StudentInboxEntityRepository;
import com.uom.cs.studentsystem.model.AcademicNewsletterEntity;
import com.uom.cs.studentsystem.model.MessageRecordEntity;
import com.uom.cs.studentsystem.model.SocialNewsletterEntity;
import com.uom.cs.studentsystem.model.SportsNewsletterEntity;
import com.uom.cs.studentsystem.repository.AcademicNewsletterEntityRepository;
import com.uom.cs.studentsystem.repository.MessageRecordEntityRepository;
import com.uom.cs.studentsystem.repository.SocialNewsletterEntityRepository;
import com.uom.cs.studentsystem.repository.SportsNewsletterEntityRepository;
import com.uom.cs.studentsystem.service.studentunion.newsletterTemplate.BasicNewsletter;
import com.uom.cs.studentsystem.service.studentunion.newsletterTemplate.NewsletterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class StudentUnion implements Subject, Serializable {
    private static final long serialVersionUID = 6687929992161255473L;
    private static final StudentUnion instance = new StudentUnion();
    //private static final NewsletterEntityRepositoryFactory newsletterEntityRepositoryFactory = new NewsletterEntityRepositoryFactory();
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

    @Autowired
    private MessageRecordEntityRepository messageRecordEntityRepository;

    @Autowired
    private StudentInboxEntityRepository studentInboxEntityRepository;

    //private static final NewsletterEntityRepositoryFactory newsletterEntityRepositoryFactory = new NewsletterEntityRepositoryFactory();

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

    public boolean getSubscribeStatus(String id, String type) {
        if (type.equals("academic")) {
            return academicNewsletterEntityRepository.existsById(id);
        } else if (type.equals("sports")) {
            return sportsNewsletterEntityRepository.existsById(id);
        } else if (type.equals("social")) {
            return socialNewsletterEntityRepository.existsById(id);
        } else {
            System.out.println("illegal subscribe type");
            //return "Error";
            return false;
        }
    }

    @Override
    public void subscribeSpecificNewsletter(Observer obj, String type) {
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
        if (type.equals("academic")) {
            if (academicNewsletterEntityRepository.existsById(obj.studentId())) {
                academicNewsletterEntityRepository.deleteById(obj.studentId());
            }
        } else if (type.equals("sports")) {
            if (sportsNewsletterEntityRepository.existsById(obj.studentId())) {
                sportsNewsletterEntityRepository.deleteById(obj.studentId());
            }
        } else if (type.equals("social")) {
            if (socialNewsletterEntityRepository.existsById(obj.studentId())) {
                socialNewsletterEntityRepository.deleteById(obj.studentId());
            }
        } else {
            System.out.println("illegal unsubscribe type");
        }
    }

    public void saveNewsletterToDatabase(BasicNewsletter basicNewsletter) {
        MessageRecordEntity messageRecordEntity = new MessageRecordEntity();
        messageRecordEntity.setIdNews(basicNewsletter.getId_news());
        messageRecordEntity.setNewsType(basicNewsletter.getNews_type());
        messageRecordEntity.setTitle(basicNewsletter.getTitle());
        messageRecordEntity.setContent(basicNewsletter.getContent());
        messageRecordEntity.setDate(basicNewsletter.getDate());
        messageRecordEntityRepository.saveAndFlush(messageRecordEntity);
    }

    public void notifyAllStudents() {
        List<BasicNewsletter> basicNewsletterList = this.loadAndReformatNewsletterFromDataBase();
        HashMap<String, List<String>> subscribeStatusList = this.loadSubscribeStatusFromDatabase();

        List<String> academicSubscribeStatus = subscribeStatusList.get("academic");
        for (String studentId:
             academicSubscribeStatus) {
            for (BasicNewsletter basicNewsletter:
                 basicNewsletterList) {
                if (basicNewsletter.getNews_type().equals("academic")) {
                    StudentInboxEntity studentInboxEntity = new StudentInboxEntity(studentId, basicNewsletter);
                    studentInboxEntityRepository.saveAndFlush(studentInboxEntity);
                }
            }
        }

        List<String> sportsSubscribeStatus = subscribeStatusList.get("sports");
        for (String studentId:
                sportsSubscribeStatus) {
            for (BasicNewsletter basicNewsletter:
                    basicNewsletterList) {
                if (basicNewsletter.getNews_type().equals("sports")) {
                    StudentInboxEntity studentInboxEntity = new StudentInboxEntity(studentId, basicNewsletter);
                    studentInboxEntityRepository.saveAndFlush(studentInboxEntity);
                }
            }
        }

        List<String> socialSubscribeStatus = subscribeStatusList.get("social");
        for (String studentId:
                socialSubscribeStatus) {
            for (BasicNewsletter basicNewsletter:
                    basicNewsletterList) {
                if (basicNewsletter.getNews_type().equals("social")) {
                    StudentInboxEntity studentInboxEntity = new StudentInboxEntity(studentId, basicNewsletter);
                    studentInboxEntityRepository.saveAndFlush(studentInboxEntity);
                }
            }
        }
    }

    public List<BasicNewsletter> loadAndReformatNewsletterFromDataBase() {
        List<MessageRecordEntity> messageRecordEntities = messageRecordEntityRepository.findAll();
        List<BasicNewsletter> basicNewsletterList = new ArrayList<>();
        for (MessageRecordEntity messageRecordEntity:
                messageRecordEntities) {
            BasicNewsletter basicNewsletter = NewsletterFactory.getNewsletter(
                    messageRecordEntity.getIdNews(), messageRecordEntity.getNewsType(),
                    messageRecordEntity.getTitle(), messageRecordEntity.getContent(),
                    messageRecordEntity.getDate());
            //assert basicNewsletter != null;
            if (basicNewsletter == null) {
                continue;
            }
            BasicNewsletter reformattedNewsletter = basicNewsletter.reformatNewsletter();
            basicNewsletterList.add(reformattedNewsletter);
        }
        return basicNewsletterList;
    }

    public HashMap<String/*type*/, List<String>/*student id*/> loadSubscribeStatusFromDatabase() {
        HashMap<String/*type*/, List<String>/*student id*/> subscribeStatusList = new HashMap<>();
        List<AcademicNewsletterEntity> academicNewsletterEntityList = academicNewsletterEntityRepository.findAll();
        List<String> academicSubscribeStudents= new ArrayList<>();
        for (AcademicNewsletterEntity academicNewsletterEntity:
             academicNewsletterEntityList) {
            academicSubscribeStudents.add(academicNewsletterEntity.getId());
        }
        subscribeStatusList.put("academic", academicSubscribeStudents);

        List<SportsNewsletterEntity> sportsNewsletterEntityList = sportsNewsletterEntityRepository.findAll();
        List<String> sportsSubscribeStudents= new ArrayList<>();
        for (SportsNewsletterEntity sportsNewsletterEntity:
                sportsNewsletterEntityList) {
            sportsSubscribeStudents.add(sportsNewsletterEntity.getId());
        }
        subscribeStatusList.put("sports", sportsSubscribeStudents);

        List<SocialNewsletterEntity> socialNewsletterEntityList = socialNewsletterEntityRepository.findAll();
        List<String> socialSubscribeStudents = new ArrayList<>();
        for (SocialNewsletterEntity socialNewsletterEntity:
             socialNewsletterEntityList) {
            socialSubscribeStudents.add(socialNewsletterEntity.getId());
        }
        subscribeStatusList.put("social", socialSubscribeStudents);

        return subscribeStatusList;
    }

    public BasicNewsletter loadNewsletterByIdFromDatabase(String news_id) {
        MessageRecordEntity messageRecordEntity = messageRecordEntityRepository.getById(news_id);
        BasicNewsletter basicNewsletter = NewsletterFactory.getNewsletter(
                messageRecordEntity.getIdNews(), messageRecordEntity.getNewsType(),
                messageRecordEntity.getTitle(), messageRecordEntity.getContent(),
                messageRecordEntity.getDate());
        assert basicNewsletter != null;
        BasicNewsletter reformattedNewsletter = basicNewsletter.reformatNewsletter();
        return reformattedNewsletter;
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
