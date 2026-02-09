package com.project.reportcardmanagement.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.project.reportcardmanagement.dao.AttendanceDAO;
import com.project.reportcardmanagement.model.Attendance;
import com.project.reportcardmanagement.util.DataBaseUtil;

public class AttendanceDAOImpl implements AttendanceDAO {

    private static final String TABLE = "attendance";

    // ---------------- ADD ATTENDANCE ----------------
    @Override
    public boolean addAttendance(Attendance a) throws Exception {
        String sql = "INSERT INTO " + TABLE + " (student_id, attendance_date, status, remarks) VALUES (?,?,?,?)";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, a.getStudentId());
            ps.setDate(2, java.sql.Date.valueOf(a.getAttendanceDate()));
            ps.setString(3, a.getStatus());
            ps.setString(4, a.getRemarks());

            return ps.executeUpdate() > 0;
        }
    }

    // ---------------- GET ATTENDANCE BY STUDENT ----------------
    @Override
    public List<Attendance> getAttendanceByStudent(String studentId) throws Exception {
        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE + " WHERE student_id=? ORDER BY attendance_date";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Attendance a = new Attendance();
                    a.setStudentId(rs.getString("student_id"));
                    a.setAttendanceDate(rs.getDate("attendance_date").toLocalDate());
                    a.setStatus(rs.getString("status"));
                    a.setRemarks(rs.getString("remarks"));
                    list.add(a);
                }
            }
        }
        return list;
    }

    // ---------------- GET TOTAL DAYS ----------------
    @Override
    public int getTotalDays(String studentId) throws Exception {
        String sql = "SELECT COUNT(*) AS total FROM " + TABLE + " WHERE student_id=? AND status='p'";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt("total");
            }
        }
        return 0;
    }

    // ---------------- GET PRESENT DAYS ----------------
    @Override
    public int getPresentDays(String studentId) throws Exception {
        String sql = "SELECT COUNT(*) AS present FROM " + TABLE + " WHERE student_id=? AND status='P'";

        try (Connection con = DataBaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return 0;
    }
}