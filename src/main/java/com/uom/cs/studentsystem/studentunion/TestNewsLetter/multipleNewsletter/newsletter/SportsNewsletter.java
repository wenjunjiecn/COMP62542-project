package com.uom.cs.studentsystem.studentunion.TestNewsLetter.multipleNewsletter.newsletter;

public class SportsNewsletter implements BasicNewsletter{

    private static final SportsNewsletter instance = new SportsNewsletter();

    //private constructor to avoid client applications to use constructor
    private SportsNewsletter(){

    }

    public static SportsNewsletter getInstance(){
        return instance;
    }

    @Override
    public String message() {
        return "----This is a SportsNewsletter----";
    }
}
