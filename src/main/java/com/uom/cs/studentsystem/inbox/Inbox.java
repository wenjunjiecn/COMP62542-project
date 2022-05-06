package com.uom.cs.studentsystem.inbox;

import com.uom.cs.studentsystem.inbox.model.StudentInboxEntity;
import com.uom.cs.studentsystem.inbox.repository.StudentInboxEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class Inbox implements Serializable {
    private static final long serialVersionUID = 6687929992161255473L;
    @Autowired
    private StudentInboxEntityRepository studentInboxEntityRepository;

    public List<StudentInboxEntity> getInboxEntityByStudentId(String studentId) {
        List<StudentInboxEntity> studentInboxEntityList = studentInboxEntityRepository.findAll();
        List<StudentInboxEntity> studentInboxEntityByIdList = new ArrayList<>();
        for (StudentInboxEntity studentInboxEntity :
                studentInboxEntityList) {
            if (studentInboxEntity.getStudentId().equals(studentId)) {
                studentInboxEntityByIdList.add(studentInboxEntity);
            }
        }
        return studentInboxEntityByIdList;
    }

    public StudentInboxEntity getInboxEntityByStudentIdByidnews(String studentId, String idnews) {
        List<StudentInboxEntity> studentInboxEntityList = studentInboxEntityRepository.findAll();
        //List<StudentInboxEntity> studentInboxEntityByIdList = new ArrayList<>();
        for (StudentInboxEntity studentInboxEntity :
                studentInboxEntityList) {
            if (studentInboxEntity.getStudentId().equals(studentId)
                    && studentInboxEntity.getIdNews().equals(idnews)) {
                return studentInboxEntity;
            }
        }
        return null;
    }
}
