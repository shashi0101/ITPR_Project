package com.project.reportcardmanagement.service;

import java.util.List;
import com.project.reportcardmanagement.model.Schedule;

public interface ScheduleService {

    // Add a new schedule
    boolean addSchedule(Schedule schedule) throws Exception;

    // View schedule by exam type (Mid/Final)
    List<Schedule> viewScheduleByExam(String examType) throws Exception;
}