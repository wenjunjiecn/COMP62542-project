package com.uom.cs.studentsystem.studentunion.model;

import com.uom.cs.studentsystem.studentunion.newsletterTemplate.BasicNewsletter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class MessageRecordEntity implements Serializable {

    private static final long serialVersionUID = 6687929992161255473L;

    @Id
    @Column(name = "idNews", nullable = false)
    private String idNews;

    private String newsType;

    //private String idStudent;

    //private String nameStudent;

    private String title;

    private String content;

    private String date;

    public MessageRecordEntity() {

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

//    create table newsLetterBase(
//    idNews varchar(255) primary key,
//    idStudent varchar(255),
//    nameStudent varchar(255),
//    title varchar(255),
//    content varchar(255),
//    date varchar(255)
//);