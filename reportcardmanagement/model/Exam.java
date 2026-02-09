package com.project.reportcardmanagement.model;

public class Exam {

    private String studentId;
    private String examType;
    private String examDate;
    private String isEligible;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getIsEligible() {
        return isEligible;
    }

    public void setIsEligible(String isEligible) {
        this.isEligible = isEligible;
    }
}