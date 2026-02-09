package com.project.reportcardmanagement.dao;

import java.util.Map;
import com.project.reportcardmanagement.model.Student;

public interface ReportCardDAO {

    // ================= STUDENT =================
    Student getStudentById(String studentId) throws Exception;

    // ================= MARKS =================
    Map<String, Integer> getMarksByStudent(String studentId) throws Exception;

    // ================= ATTENDANCE =================
    int getTotalClasses(String studentId) throws Exception;

    int getPresentCount(String studentId) throws Exception;
}