package com.zuitem.service;

import com.zuitem.domain.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findAll();
    void addschedule(Schedule schedule);
    void delSchedule(List<Integer> list);
    void editschedule(Schedule schedule);
}
