package com.project.reportcardmanagement.dao;

import java.util.List;
import com.project.reportcardmanagement.model.Attendance;

public interface AttendanceDAO {

    boolean addAttendance(Attendance a) throws Exception;

    List<Attendance> getAttendanceByStudent(String studentId) throws Exception;

    int getTotalDays(String studentId) throws Exception;

    int getPresentDays(String studentId) throws Exception;
}