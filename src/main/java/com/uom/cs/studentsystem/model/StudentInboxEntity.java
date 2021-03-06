package com.uom.cs.studentsystem.model;

import com.uom.cs.studentsystem.service.studentunion.newsletterTemplate.BasicNewsletter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@IdClass(StudentInboxEntity.class)
public class StudentInboxEntity implements Serializable {

    private static final long serialVersionUID = 6687929992161255473L;

    @Id
    @Column(name = "studentId", nullable = false)
    private String studentId;

    @Id
    @Column(name = "idNews", nullable = false)
    private String idNews;

    private String newsType;

    //private String idStudent;

    //private String nameStudent;

    private String title;

    private String content;

    private String date;

    public StudentInboxEntity() {

    }

    public StudentInboxEntity(String studentId, BasicNewsletter basicNewsletter) {
        this.studentId = studentId;
        this.idNews = basicNewsletter.getId_news();
        this.newsType = basicNewsletter.getNews_type();
        this.title = basicNewsletter.getTitle();
        this.content = basicNewsletter.getContent();
        this.date = basicNewsletter.getDate();
    }

    public StudentInboxEntity(String studentId, MessageRecordEntity messageRecordEntity) {
        this.studentId = studentId;
        this.idNews = messageRecordEntity.getIdNews();
        this.newsType = messageRecordEntity.getNewsType();
        this.title = messageRecordEntity.getTitle();
        this.content = messageRecordEntity.getContent();
        this.date = messageRecordEntity.getDate();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getIdNews() {
        return idNews;
    }

    public void setIdNews(String idNews) {
        this.idNews = idNews;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

