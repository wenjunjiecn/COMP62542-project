package com.uom.cs.studentsystem.service.studentunion.newsletterTemplate;

public abstract class BasicNewsletter {
    private String id_news;
    private String news_type;
    protected String title;
    protected String content;
    private String date;

    public abstract String writeTitle();
    public abstract String writeContent();


    public BasicNewsletter(String id_news, String news_type, String title, String content, String date) {
        this.id_news = id_news;
        this.news_type = news_type;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String writeDate() {
        //
        return this.date;
    }

    public final BasicNewsletter reformatNewsletter() {
        String title = writeTitle();
        String content = writeContent();
        String date = writeDate();
        BasicNewsletter basicNewsletter = NewsletterFactory.getNewsletter(id_news, news_type, title, content, date);
        return basicNewsletter;
    }

    public String getId_news() {
        return id_news;
    }

    public void setId_news(String id_news) {
        this.id_news = id_news;
    }

    public String getNews_type() {
        return news_type;
    }

    public void setNews_type(String news_type) {
        this.news_type = news_type;
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

    public String message() {
        return "----This is an BasicNewsletter----";
    }
}

/*
create table newsLetterBase(
 idNews varchar(255) primary key,
 idStudent varchar(255),
 nameStudent varchar(255),
 title varchar(255),
 content varchar(255),
 date varchar(255)
);
 */

/*
INSERT INTO newsLetterBase
VALUES ("00001", "22222", "James", "~~AcademicNewsletter~~", "Content1 Content2", "2022-5-5");
 */