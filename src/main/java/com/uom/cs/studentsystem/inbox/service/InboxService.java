package com.uom.cs.studentsystem.inbox.service;

import com.uom.cs.studentsystem.inbox.Inbox;
import com.uom.cs.studentsystem.inbox.model.StudentInboxEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InboxService {

    @Autowired
    private Inbox inbox;

    public List<StudentInboxEntity> getInboxEntityByStudentId(String studentId) {
        return inbox.getInboxEntityByStudentId(studentId);
    }

    public StudentInboxEntity getInboxEntityByStudentIdByidnews(String studentId, String idnews) {
        return inbox.getInboxEntityByStudentIdByidnews(studentId, idnews);
    }
}
