package com.uom.cs.studentsystem.studentadmissionoffice;

public class AdmissionOfficeReminder {

    private String id_news;
    private String news_type;
    protected String title;
    protected String content;
    private String date;

    public AdmissionOfficeReminder(String id_news, String news_type, String title, String content, String date) {
        this.id_news = id_news;
        this.news_type = news_type;
        this.title = title;
        this.content = content;
        this.date = date;
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
}
