package com.uom.cs.studentsystem.service;

import com.uom.cs.studentsystem.model.AdditionalActivityEntity;
import com.uom.cs.studentsystem.model.CourseEntity;
import com.uom.cs.studentsystem.model.CourseSelectionEntity;
import com.uom.cs.studentsystem.model.CourseSelectionRecordEntity;
import com.uom.cs.studentsystem.repository.AdditionalActivityEntityRepository;
import com.uom.cs.studentsystem.repository.CourseEntityRepository;
import com.uom.cs.studentsystem.repository.CourseSelectionEntityRepository;
import com.uom.cs.studentsystem.repository.CourseSelectionRecordEntityRepository;
import com.uom.cs.studentsystem.service.status.Student;
import com.uom.cs.studentsystem.service.timetable.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Service
public class TimetableService {
    @Autowired
    AdditionalActivityEntityRepository additionalActivityEntityRepository;
    @Autowired
    CourseSelectionRecordEntityRepository courseSelectionRecordEntityRepository;
    @Autowired
    CourseEntityRepository courseEntityRepository;

    public List<TimetableItem> getBasicTimetableDetailsOrderByTime(String id) {
        List<IActivity> list = new LinkedList<>();
        BasicTimetable basicTimetable = new BasicTimetable();

        List<AdditionalActivityEntity> additionActivities = additionalActivityEntityRepository.findByStudentid(id);
        List<CourseSelectionRecordEntity> courseActivities = courseSelectionRecordEntityRepository.findAllByStudentId(id);

        for (AdditionalActivityEntity activity : additionActivities) {
            AdditionActivity i = new AdditionActivity(activity);
            basicTimetable.add(i);
        }

//        for (CourseSelectionEntity courseActivity : courseActivities) {
//            CourseEntity courseEntity = courseEntityRepository.findById(courseActivity.getCourseid()).get();
//            CourseSelection i = new CourseSelection(courseActivity, courseEntity);
//            basicTimetable.add(i);
//        }

        for (CourseSelectionRecordEntity courseActivity : courseActivities) {
            CourseEntity courseEntity = courseEntityRepository.findById(courseActivity.getCourseId()).get();
            SelectedCourse selectedCourse = new SelectedCourse(courseEntity);
            basicTimetable.add(selectedCourse);
        }

        Iterator iterator = basicTimetable.createIterator();
        List<TimetableItem> orderedList = new LinkedList<>();

        while (iterator.hasNext()) {
            TimetableItem next = iterator.next();
            orderedList.add(next);
        }

        return orderedList;
    }

    public void addAdditionalActivity(AdditionActivity activity) {
        AdditionalActivityEntity entity = activity.convertToEntity();
        System.out.println("entity===" + entity);
        additionalActivityEntityRepository.saveAndFlush(entity);
    }

    public boolean removeAdditionalActivity(Student student, String messageId) {
        long mid = Long.parseLong(messageId);
        if (isMessageMatchStudent(student, mid)) {
            additionalActivityEntityRepository.deleteById(mid);
            return true;
        }
        return false;
    }

    /**
     * Check if the message belongs to the current user
     * to avoid illegal deletion of messages that do not belong to the user
     */
    private boolean isMessageMatchStudent(Student student, Long mid) {
        String stuId = student.getId();
        AdditionalActivityEntity entity = additionalActivityEntityRepository.getById(mid);
        if (stuId.equals(entity.getStudentid())) {
            return true;
        }
        return false;
    }

}
