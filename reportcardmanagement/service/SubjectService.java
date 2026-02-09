package com.project.reportcardmanagement.service;

import java.util.List;
import com.project.reportcardmanagement.model.Subject;

public interface SubjectService {

    boolean addSubject(Subject s) throws Exception;

    boolean updateSubject(Subject s) throws Exception;

    boolean deleteSubject(String subjectCode) throws Exception;

    Subject getSubjectByCode(String subjectCode) throws Exception;

    List<Subject> getAllSubjects() throws Exception;
}