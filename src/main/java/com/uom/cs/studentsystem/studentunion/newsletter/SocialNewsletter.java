package com.uom.cs.studentsystem.studentunion.newsletter;

import com.uom.cs.studentsystem.studentunion.model.SocialNewsletterEntity;

public class SocialNewsletter implements BasicNewsletter{

    private static final SocialNewsletter instance = new SocialNewsletter();

    //private constructor to avoid client applications to use constructor
    private SocialNewsletter(){

    }

    public static SocialNewsletter getInstance(){
        return instance;
    }

    @Override
    public String message() {
        return "----This is a SocialNewsletter----";
    }
}
