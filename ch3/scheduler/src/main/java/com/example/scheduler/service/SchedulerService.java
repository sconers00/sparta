package com.example.scheduler.service;

import com.example.scheduler.dto.SchedulerRequestDto;
import com.example.scheduler.dto.SchedulerResponseDto;

import java.util.List;

public interface SchedulerService {

    SchedulerResponseDto addSchedule(SchedulerRequestDto dto);

    List<SchedulerResponseDto> findSchedules(SchedulerRequestDto dto);

    SchedulerResponseDto findSchedulerById(Long id);
}
