package com.project.reportcardmanagement.dao;

import java.util.List;
import com.project.reportcardmanagement.model.Marks;

public interface MarksDAO {

    boolean addMarks(Marks m) throws Exception;

    boolean updateMarks(Marks m) throws Exception;
    
    boolean deleteMarks(String studentId, String subjectCode) throws Exception;

    List<Marks> getMarksByStudent(String studentId) throws Exception;

    List<Marks> getAllMarks() throws Exception;
}