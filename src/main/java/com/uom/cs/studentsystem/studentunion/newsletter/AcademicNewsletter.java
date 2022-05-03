package com.uom.cs.studentsystem.studentunion.newsletter;

public class AcademicNewsletter implements BasicNewsletter {

    private static final AcademicNewsletter instance = new AcademicNewsletter();

    //private constructor to avoid client applications to use constructor
    private AcademicNewsletter(){

    }

    public static AcademicNewsletter getInstance(){
        return instance;
    }

    @Override
    public String message() {
        return "----This is an AcademicNewsletter----";
    }
}
