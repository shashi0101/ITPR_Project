package com.project.reportcardmanagement.dao.impl;

import com.project.reportcardmanagement.dao.SubjectDAO;
import com.project.reportcardmanagement.model.Subject;
import com.project.reportcardmanagement.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {

    private static final String TABLE = "subject";

    // Utility method to map ResultSet to Subject object
    private Subject mapResultSetToSubject(ResultSet rs) throws SQLException {
        return new Subject(
                rs.getString("subject_code"),
                rs.getString("subject_name"),
                rs.getInt("max_marks"),
                rs.getInt("min_marks")
        );
    }

    @Override
    public boolean addSubject(Subject s) throws SQLException {
        String sql = "INSERT INTO " + TABLE + " (subject_code, subject_name, max_marks, min_marks) VALUES (?,?,?,?)";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getSubjectCode());
            ps.setString(2, s.getSubjectName());
            ps.setInt(3, s.getMaxMarks());
            ps.setInt(4, s.getMinMarks());

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean updateSubject(Subject s) throws SQLException {
        String sql = "UPDATE " + TABLE + " SET subject_name=?, max_marks=?, min_marks=? WHERE subject_code=?";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getSubjectName());
            ps.setInt(2, s.getMaxMarks());
            ps.setInt(3, s.getMinMarks());
            ps.setString(4, s.getSubjectCode());

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteSubject(String subjectCode) throws SQLException {
        String sql = "DELETE FROM " + TABLE + " WHERE subject_code=?";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, subjectCode);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Subject getSubjectByCode(String subjectCode) throws SQLException {
        String sql = "SELECT * FROM " + TABLE + " WHERE subject_code=?";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, subjectCode);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToSubject(rs);
                }
            }
        }
        return null;
    }

    @Override
    public List<Subject> getAllSubjects() throws SQLException {
        List<Subject> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE;

        try (Connection conn = DataBaseUtil.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(mapResultSetToSubject(rs));
            }
        }
        return list;
    }
}