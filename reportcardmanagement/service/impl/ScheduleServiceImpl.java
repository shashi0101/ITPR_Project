package com.project.reportcardmanagement.service.impl;

import java.util.List;

import com.project.reportcardmanagement.dao.ScheduleDAO;
import com.project.reportcardmanagement.dao.impl.ScheduleDAOImpl;
import com.project.reportcardmanagement.model.Schedule;
import com.project.reportcardmanagement.service.ScheduleService;

public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleDAO dao = new ScheduleDAOImpl();

    @Override
    public boolean addSchedule(Schedule schedule) throws Exception {
        return dao.addSchedule(schedule);
    }

    @Override
    public List<Schedule> viewScheduleByExam(String examType) throws Exception {
        return dao.viewScheduleByExam(examType);
    }
}