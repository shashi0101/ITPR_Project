package com.project.reportcardmanagement.model;

public class Schedule {

    private int scheduleId;
    private String examType;
    private String subjectCode;
    private String examDate;     // YYYY-MM-DD
    private String startTime;    // 10:00 AM
    private String endTime;      // 1:00 PM

    // ========== Constructors ==========
    public Schedule() {
    }

    public Schedule(int scheduleId, String examType, String subjectCode,
                    String examDate, String startTime, String endTime) {
        this.scheduleId = scheduleId;
        this.examType = examType;
        this.subjectCode = subjectCode;
        this.examDate = examDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // ========== Getters & Setters ==========
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    // ========== toString ==========
    @Override
    public String toString() {
        return "Schedule [scheduleId=" + scheduleId +
               ", examType=" + examType +
               ", subjectCode=" + subjectCode +
               ", examDate=" + examDate +
               ", startTime=" + startTime +
               ", endTime=" + endTime + "]";
    }
}