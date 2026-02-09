package com.project.reportcardmanagement.model;

import java.util.Map;

public class ReportCard {

    private String studentId;
    private String studentName;
    private String className;

    // Map<SubjectCode, Marks>
    private Map<String, Integer> marksMap;

    private int totalMarks;
    private double marksPercentage;
    private double attendancePercentage;
    private String result; // Pass/Fail

    // ===== Constructors =====
    public ReportCard() {}

    public ReportCard(String studentId, String studentName, String className,
                      Map<String, Integer> marksMap, int totalMarks,
                      double marksPercentage, double attendancePercentage,
                      String result) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.className = className;
        this.marksMap = marksMap;
        this.totalMarks = totalMarks;
        this.marksPercentage = marksPercentage;
        this.attendancePercentage = attendancePercentage;
        this.result = result;
    }

    // ===== Getters & Setters =====
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }

    public Map<String, Integer> getMarksMap() {
        return marksMap;
    }
    public void setMarksMap(Map<String, Integer> marksMap) {
        this.marksMap = marksMap;
    }

    public int getTotalMarks() {
        return totalMarks;
    }
    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public double getMarksPercentage() {
        return marksPercentage;
    }
    public void setMarksPercentage(double marksPercentage) {
        this.marksPercentage = marksPercentage;
    }

    public double getAttendancePercentage() {
        return attendancePercentage;
    }
    public void setAttendancePercentage(double attendancePercentage) {
        this.attendancePercentage = attendancePercentage;
    }

    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    // ===== Helper Methods =====

    /**
     * Calculate total marks from marksMap
     */
    public void calculateTotalMarks() {
        if (marksMap != null && !marksMap.isEmpty()) {
            this.totalMarks = marksMap.values().stream().mapToInt(Integer::intValue).sum();
        } else {
            this.totalMarks = 0;
        }
    }

    /**
     * Calculate marks percentage
     */
    public void calculateMarksPercentage(int maxTotalMarks) {
        if (maxTotalMarks > 0) {
            this.marksPercentage = (double) totalMarks / maxTotalMarks * 100;
        } else {
            this.marksPercentage = 0;
        }
    }

    /**
     * Determine result based on marksPercentage and attendancePercentage
     */
    public void determineResult(double passPercentage, double minAttendance) {
        if (marksPercentage >= passPercentage && attendancePercentage >= minAttendance) {
            this.result = "Pass";
        } else {
            this.result = "Fail";
        }
    }

    @Override
    public String toString() {
        return "ReportCard{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", className='" + className + '\'' +
                ", marksMap=" + marksMap +
                ", totalMarks=" + totalMarks +
                ", marksPercentage=" + String.format("%.2f", marksPercentage) +
                ", attendancePercentage=" + String.format("%.2f", attendancePercentage) +
                ", result='" + result + '\'' +
                '}';
    }
}