package com.example.scheduler.controller;

import com.example.scheduler.dto.SchedulerRequestDto;
import com.example.scheduler.dto.SchedulerResponseDto;
import com.example.scheduler.service.SchedulerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final SchedulerService schedulerservice;
    public ScheduleController(SchedulerService schedulerservice) {
        this.schedulerservice = schedulerservice;
    }

    @PostMapping()//일정 추가
    public ResponseEntity<SchedulerResponseDto> addSchedule(@RequestBody SchedulerRequestDto dto) {
        //serviceLayer 호출 응답
        return new ResponseEntity<>(schedulerservice.addSchedule(dto), HttpStatus.CREATED);
    }

    @GetMapping()//일정 검색
    public List<SchedulerResponseDto> findSchedules(@RequestBody SchedulerRequestDto dto){

        return new ResponseEntity<>(schedulerservice.findSchedules(dto),HttpStatus.OK).getBody();
    }

    @GetMapping("/{id}")//id로 일정 조회
    public ResponseEntity<SchedulerResponseDto> findSchedulerById(@PathVariable Long id){
        return new ResponseEntity<>(schedulerservice.findSchedulerById(id),HttpStatus.OK);
    }



}
