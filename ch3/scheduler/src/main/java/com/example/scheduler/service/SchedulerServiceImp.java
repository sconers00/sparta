package com.example.scheduler.service;


import com.example.scheduler.dto.SchedulerResponseDto;
import com.example.scheduler.dto.SchedulerRequestDto;
import com.example.scheduler.dto.SchedulerSearchRequestDto;
import com.example.scheduler.dto.SchedulerSearchResponseDto;
import com.example.scheduler.entity.Schedule;
import com.example.scheduler.repository.SchedulerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.server.ResponseStatusException;
//import org.springframework.http.HttpStatus;

@Service
public class SchedulerServiceImp implements SchedulerService {

    private final SchedulerRepository schedulerRepository;

    public SchedulerServiceImp(SchedulerRepository schedulerRepository) {
        this.schedulerRepository = schedulerRepository;
    }

    @Override
    public SchedulerResponseDto addSchedule(SchedulerRequestDto dto) {

        Schedule schedule = new Schedule(dto.getName(), dto.getTodo(), dto.getPswd());

        return schedulerRepository.addSchedule(schedule);
    }

    @Override
    public List<SchedulerSearchResponseDto> findSchedules(SchedulerSearchRequestDto dto) {

        String name=dto.getName();
        String Postdate=dto.getPostdate();

        return schedulerRepository.findSchedules(name, Postdate);
    }

   /* @Override 고장
    public SchedulerSearchResponseDto findSchedulerById(Long id) {
        Schedule schedule = SchedulerRepository.findSchedulerByIdOrElseThrow(id);
        return new SchedulerSearchResponseDto(schedule);
    }*/


}
