package com.uom.cs.studentsystem.service.course;

import com.uom.cs.studentsystem.service.course.ICourse;

/**
 * @author wenjunjie
 * @version 1.0
 */
public class CourseFactory {
    public static ICourse create(String type, String id){
        long l = Long.parseLong(id);
       if(type.equals("computer")){
           ComputerCourse computerCourse = new ComputerCourse();

           computerCourse.setId(l);
           return computerCourse;
       }else if(type.equals("mathematic")){
           MathmaticCourse mathmaticCourse = new MathmaticCourse();

           mathmaticCourse.setId(l);
           return mathmaticCourse;

       }
       return null;
    }
}
