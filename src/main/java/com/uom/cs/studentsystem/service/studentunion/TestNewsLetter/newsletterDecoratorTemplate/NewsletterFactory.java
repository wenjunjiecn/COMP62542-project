package com.uom.cs.studentsystem.service.studentunion.TestNewsLetter.newsletterDecoratorTemplate;

public class NewsletterFactory {
    public static BasicNewsletter getNewsletter(String id_news, String news_type, String title, String content, String date) {
        switch (news_type) {
            case "academic":
                return new AcademicNewsletter(id_news, news_type, title, content, date);
            case "sports":
                return new SportsNewsletter(id_news, news_type, title, content, date);
            case "social":
                return new SocialNewsletter(id_news, news_type, title, content, date);
            default:
                return null;
        }
    }
}
