package com.uom.cs.studentsystem.service.studentunion.TestNewsLetter.newsletterDecoratorTemplate;

public class SocialNewsletter extends NewsletterDecorator {

    //private static final SocialNewsletter instance = new SocialNewsletter();

    public SocialNewsletter(BasicNewsletter basicNewsletter) {
        super(basicNewsletter);
    }

    @Override
    public String writeTitle() {
        //return "~~~~" + this.title + "~~~~";
        return "~~~" + super.writeTitle() + "~~~";
    }

    @Override
    public String writeContent() {
        return content + "\n\n\n" + "Single boy and single girl, join us and make friends!";
    }

    //private constructor to avoid client applications to use constructor
    public SocialNewsletter(String id_news, String news_type, String title, String content, String date){
        super(id_news, news_type, title, content, date);
    }

//    public static SocialNewsletter getInstance(){
//        return instance;
//    }

    @Override
    public String message() {
        return "----This is a SocialNewsletter----";
    }
}
