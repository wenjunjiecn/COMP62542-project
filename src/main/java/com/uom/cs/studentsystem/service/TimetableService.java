package com.uom.cs.studentsystem.service;

import com.uom.cs.studentsystem.model.AdditionalActivityEntity;
import com.uom.cs.studentsystem.repository.AdditionalActivityEntityRepository;
import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.service.timetable.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Service
public class TimetableService {
    @Autowired
    AdditionalActivityEntityRepository additionalActivityEntityRepository;
    public List<TimetableItem> getBasicTimetableDetailsOrderByTime(String id){
        List<IActivity> list= new LinkedList<>();
        BasicTimetable basicTimetable = new BasicTimetable();
        List<AdditionalActivityEntity> activities = additionalActivityEntityRepository.findByStudentid(id);
        System.out.println(additionalActivityEntityRepository.findAll());
        System.out.println("this is the 2 =="+activities);
        for (AdditionalActivityEntity activity : activities) {
            AdditionActivity i = new AdditionActivity(activity);
            basicTimetable.add(i);
        }
        Iterator iterator = basicTimetable.createIterator();
        while (iterator.hasNext()) {
            TimetableItem next = iterator.next();
        }
        return basicTimetable.getActivityDetails();
    }
    public void addAdditionalActivity(AdditionActivity activity){
        AdditionalActivityEntity entity= activity.convertToEntity();
        System.out.println("entity==="+entity);
        additionalActivityEntityRepository.saveAndFlush(entity);
    }

    public boolean removeAdditionalActivity(Student student,String messageId){
        long mid = Long.parseLong(messageId);
        if(isMessageMatchStudent(student,mid)){

            additionalActivityEntityRepository.deleteById(mid);
            return true;
        }
        return false;
    }

    /**
     *Check if the message belongs to the current user
     *to avoid illegal deletion of messages that do not belong to the user
     */
    private boolean isMessageMatchStudent(Student student, Long mid){
        String stuId = student.getId();
        AdditionalActivityEntity entity = additionalActivityEntityRepository.getById(mid);
        if(stuId.equals(entity.getStudentid())){
            return true;
        }
        return false;
    }

}
