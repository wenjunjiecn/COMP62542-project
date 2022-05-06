package com.uom.cs.studentsystem.studentunion.newsletterTemplate;

public class SportsNewsletter extends BasicNewsletter {

    //private static final SportsNewsletter instance = new SportsNewsletter();

    @Override
    public String writeTitle() {
        return "!!--!!--" + this.title + "--!!--!!";
    }

    @Override
    public String writeContent() {
        return content + "\n\n\n" + "Join us! Let's exercise together!";
    }

    //private constructor to avoid client applications to use constructor
    public SportsNewsletter(String id_news, String news_type, String title, String content, String date){
        super(id_news, news_type, title, content, date);
    }

//    public static SportsNewsletter getInstance(){
//        return instance;
//    }

    @Override
    public String message() {
        return "----This is a SportsNewsletter----";
    }
}
