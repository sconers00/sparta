package com.example.scheduler.service;

import com.example.scheduler.dto.SchedulerRequestDto;
import com.example.scheduler.dto.SchedulerResponseDto;
import com.example.scheduler.dto.SchedulerSearchRequestDto;
import com.example.scheduler.dto.SchedulerSearchResponseDto;

import java.util.List;

public interface SchedulerService {

    SchedulerResponseDto addSchedule(SchedulerRequestDto dto);
    List<SchedulerSearchResponseDto> findSchedules(SchedulerSearchRequestDto dto);
    //SchedulerSearchResponseDto findSchedulerById(Long id); 고장
}
