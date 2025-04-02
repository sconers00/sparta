package com.example.scheduler.service;


import com.example.scheduler.dto.SchedulerResponseDto;
import com.example.scheduler.dto.SchedulerRequestDto;
import com.example.scheduler.entity.Schedule;
import com.example.scheduler.repository.SchedulerRepository;
import org.springframework.stereotype.Service;

import java.util.List;


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
    public List<SchedulerResponseDto> findSchedules(SchedulerRequestDto dto) {

        String name=dto.getName();
        String Postdate=dto.getPostdate();

        return schedulerRepository.findSchedules(name, Postdate);
    }

    @Override
    public SchedulerResponseDto findSchedulerById(Long id) {//오류 반환 포함 검색 연결기
        Schedule schedule = schedulerRepository.findSchedulerById(id).orElseThrow(()->new IllegalArgumentException("해당 id의 스케쥴이 없습니다"));
        return new SchedulerResponseDto(
                schedule.getId(),
                schedule.getTodo(),
                schedule.getName(),
                schedule.getPostdate(),
                schedule.getEditdate()
        );
    }


}
