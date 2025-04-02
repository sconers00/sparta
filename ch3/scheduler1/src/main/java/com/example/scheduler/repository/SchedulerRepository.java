package com.example.scheduler.repository;

import com.example.scheduler.dto.SchedulerResponseDto;
import com.example.scheduler.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface SchedulerRepository {
    SchedulerResponseDto addSchedule(Schedule schedule);
    List<SchedulerResponseDto> findSchedules(String name,String postdate);
    Optional<Schedule> findSchedulerById(Long id);


}
