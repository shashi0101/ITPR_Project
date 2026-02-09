package com.project.reportcardmanagement.service.impl;

import com.project.reportcardmanagement.dao.ExamDAO;
import com.project.reportcardmanagement.dao.impl.ExamDAOImpl;
import com.project.reportcardmanagement.model.Exam;
import com.project.reportcardmanagement.service.ExamService;

public class ExamServiceImpl implements ExamService {

    ExamDAO examDAO = new ExamDAOImpl();

    @Override
    public boolean addExam(Exam exam) throws Exception {
        return examDAO.addExam(exam);
    }

    @Override
    public Exam getExamByStudentId(String studentId) throws Exception {
        return examDAO.getExamByStudentId(studentId);
    }
}