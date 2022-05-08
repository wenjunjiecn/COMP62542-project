package com.uom.cs.studentsystem.service.studentunion.TestNewsLetter.newsletterDecoratorTemplate;

public class NewsletterDecorator extends BasicNewsletter{

    protected BasicNewsletter basicNewsletter;

//    public NewsletterDecorator (String id_news, String news_type, String title, String content, String date) {
//        super(id_news, news_type, title, content, date);
//    }

    public NewsletterDecorator(BasicNewsletter basicNewsletter) {
        this.basicNewsletter = basicNewsletter;
    }

    public NewsletterDecorator(String id_news, String news_type, String title, String content, String date){
        super(id_news, news_type, title, content, date);
    }

    @Override
    public String writeContent() {
        return this.content;
    }
}
