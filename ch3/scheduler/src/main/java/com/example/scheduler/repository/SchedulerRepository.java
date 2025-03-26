package com.example.scheduler.repository;

import com.example.scheduler.dto.SchedulerResponseDto;
import com.example.scheduler.dto.SchedulerSearchRequestDto;
import com.example.scheduler.dto.SchedulerSearchResponseDto;
import com.example.scheduler.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface SchedulerRepository {
    SchedulerResponseDto addSchedule(Schedule schedule);
    List<SchedulerSearchResponseDto> findSchedules(String name,String postdate);
    //Optional<Schedule> findSchedulerByIdOrElseThrow(Long id); 고장


}
