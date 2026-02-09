package com.project.reportcardmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.reportcardmanagement.dao.ScheduleDAO;
import com.project.reportcardmanagement.model.Schedule;
import com.project.reportcardmanagement.util.DataBaseUtil;

public class ScheduleDAOImpl implements ScheduleDAO {

    // ================= ADD SCHEDULE =================
    @Override
    public boolean addSchedule(Schedule s) throws Exception {

        String sql = "INSERT INTO schedule "
                   + "(exam_type, subject_code, exam_date, start_time, end_time) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getExamType());
            ps.setString(2, s.getSubjectCode());
            ps.setString(3, s.getExamDate());   // ✅ String
            ps.setString(4, s.getStartTime());  // ✅ String
            ps.setString(5, s.getEndTime());    // ✅ String

            return ps.executeUpdate() > 0;
        }
    }

    // ================= VIEW SCHEDULE BY EXAM =================
    @Override
    public List<Schedule> viewScheduleByExam(String examType) throws Exception {

        List<Schedule> list = new ArrayList<>();

        String sql = "SELECT * FROM schedule WHERE exam_type = ?";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, examType);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Schedule s = new Schedule();
                s.setExamType(rs.getString("exam_type"));
                s.setSubjectCode(rs.getString("subject_code"));
                s.setExamDate(rs.getString("exam_date"));
                s.setStartTime(rs.getString("start_time"));
                s.setEndTime(rs.getString("end_time"));

                list.add(s);
            }
        }
        return list;
    }
}