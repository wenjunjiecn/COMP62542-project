package com.uom.cs.studentsystem.service.studentunion.TestNewsLetter.newsletterDecoratorTemplate;

//public class AcademicNewsletter1 implements BasicNewsletter1 {
public class AcademicNewsletter extends NewsletterDecorator {

    //private static final AcademicNewsletter instance = new AcademicNewsletter();

    //private constructor to avoid client applications to use constructor
    public AcademicNewsletter(String id_news, String news_type, String title, String content, String date){
        super(id_news, news_type, title, content, date);
    }

    public AcademicNewsletter(BasicNewsletter basicNewsletter) {
        super(basicNewsletter);
    }

//    public static AcademicNewsletter getInstance(){
//        return instance;
//    }

    @Override
    public String writeTitle() {
        //return "(-^-)" + this.title + "(-^-)";
        return "(-^-)" + super.writeTitle() + "(-^-)";
    }

    @Override
    public String writeContent() {
        return content + "\n\n\n" + "Academic Union looks forward to your joining!";
    }

    @Override
    public String message() {
        return "----This is an AcademicNewsletter----";
    }
}
