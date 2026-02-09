package com.project.reportcardmanagement.service.impl;

import java.util.List;
import com.project.reportcardmanagement.dao.AttendanceDAO;
import com.project.reportcardmanagement.dao.impl.AttendanceDAOImpl;
import com.project.reportcardmanagement.model.Attendance;
import com.project.reportcardmanagement.service.AttendanceService;

public class AttendanceServiceImpl implements AttendanceService {

    AttendanceDAO dao = new AttendanceDAOImpl();

    @Override
    public boolean addAttendance(Attendance a) throws Exception {
        return dao.addAttendance(a);
    }

    @Override
    public List<Attendance> getAttendanceByStudent(String studentId) throws Exception {
        return dao.getAttendanceByStudent(studentId);
    }

    @Override
    public int getTotalDays(String studentId) throws Exception {
        return dao.getTotalDays(studentId);
    }

    @Override
    public int getPresentDays(String studentId) throws Exception {
        return dao.getPresentDays(studentId);
    }
}