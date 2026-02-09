package com.project.reportcardmanagement.service.impl;

import java.util.Map;

import com.project.reportcardmanagement.dao.ReportCardDAO;
import com.project.reportcardmanagement.dao.impl.ReportCardDAOImpl;
import com.project.reportcardmanagement.model.ReportCard;
import com.project.reportcardmanagement.model.Student;
import com.project.reportcardmanagement.service.ReportCardService;

public class ReportCardServiceImpl implements ReportCardService {

    private ReportCardDAO reportCardDAO = new ReportCardDAOImpl();

    @Override
    public ReportCard generateReportCard(String studentId) throws Exception {

        // 1️⃣ Get student details
        Student student = reportCardDAO.getStudentById(studentId);
        if (student == null) {
            return null; // student not found
        }

        // 2️⃣ Get marks
        Map<String, Integer> marksMap = reportCardDAO.getMarksByStudent(studentId);

        // 3️⃣ Get attendance
        int totalClasses = reportCardDAO.getTotalClasses(studentId);
        int presentDays = reportCardDAO.getPresentCount(studentId);

        double attendancePercentage = (totalClasses > 0) ? (presentDays * 100.0 / totalClasses) : 0;

        // 4️⃣ Calculate total marks and percentage
        int totalMarks = 0;
        int maxTotalMarks = marksMap.size() * 100; // assuming each subject max 100
        for (int m : marksMap.values()) {
            totalMarks += m;
        }
        double marksPercentage = (maxTotalMarks > 0) ? (totalMarks * 100.0 / maxTotalMarks) : 0;

        // 5️⃣ Determine result (Pass/Fail)
        String result = (marksPercentage >= 40 && attendancePercentage >= 75) ? "Pass" : "Fail";

        // 6️⃣ Build ReportCard object
        ReportCard reportCard = new ReportCard();
        reportCard.setStudentId(student.getStudentId());
        reportCard.setStudentName(student.getStudentName());
        reportCard.setClassName(student.getClassName());
        reportCard.setMarksMap(marksMap);
        reportCard.setTotalMarks(totalMarks);
        reportCard.setMarksPercentage(marksPercentage);
        reportCard.setAttendancePercentage(attendancePercentage);
        reportCard.setResult(result);

        return reportCard;
    }
}