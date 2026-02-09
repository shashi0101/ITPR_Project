package com.project.reportcardmanagement.service.impl;

import com.project.reportcardmanagement.dao.SubjectDAO;
import com.project.reportcardmanagement.dao.impl.SubjectDAOImpl;
import com.project.reportcardmanagement.model.Subject;
import com.project.reportcardmanagement.service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    private SubjectDAO dao;

    public SubjectServiceImpl() {
        this.dao = new SubjectDAOImpl(); // DAO injected
    }

    @Override
    public boolean addSubject(Subject s) throws Exception {
        validateSubject(s);
        return dao.addSubject(s);
    }

    @Override
    public boolean updateSubject(Subject s) throws Exception {
        validateSubject(s);
        return dao.updateSubject(s);
    }

    @Override
    public boolean deleteSubject(String subjectCode) throws Exception {
        if(subjectCode == null || subjectCode.trim().isEmpty())
            throw new IllegalArgumentException("Subject code cannot be empty");
        return dao.deleteSubject(subjectCode);
    }

    @Override
    public Subject getSubjectByCode(String subjectCode) throws Exception {
        if(subjectCode == null || subjectCode.trim().isEmpty())
            throw new IllegalArgumentException("Subject code cannot be empty");
        return dao.getSubjectByCode(subjectCode);
    }

    @Override
    public List<Subject> getAllSubjects() throws Exception {
        return dao.getAllSubjects();
    }

    // ------------------- VALIDATION -------------------
    private void validateSubject(Subject s) {
        if(s == null)
            throw new IllegalArgumentException("Subject cannot be null");
        if(s.getSubjectCode() == null || s.getSubjectCode().trim().isEmpty())
            throw new IllegalArgumentException("Subject code cannot be empty");
        if(s.getSubjectName() == null || s.getSubjectName().trim().isEmpty())
            throw new IllegalArgumentException("Subject name cannot be empty");
        if(s.getMaxMarks() < s.getMinMarks())
            throw new IllegalArgumentException("Max marks cannot be less than min marks");
        if(s.getMinMarks() < 0 || s.getMaxMarks() < 0)
            throw new IllegalArgumentException("Marks cannot be negative");
    }
}