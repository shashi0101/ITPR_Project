package com.project.reportcardmanagement.service;

import com.project.reportcardmanagement.model.Exam;

public interface ExamService {

    boolean addExam(Exam exam) throws Exception;

    Exam getExamByStudentId(String studentId) throws Exception;
}