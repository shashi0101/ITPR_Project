package com.project.reportcardmanagement.dao;

import com.project.reportcardmanagement.model.Exam;

public interface ExamDAO {

    boolean addExam(Exam exam) throws Exception;

    Exam getExamByStudentId(String studentId) throws Exception;
}