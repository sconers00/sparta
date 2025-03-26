package com.example.scheduler.controller;

import com.example.scheduler.dto.SchedulerRequestDto;
import com.example.scheduler.dto.SchedulerResponseDto;
import com.example.scheduler.dto.SchedulerSearchRequestDto;
import com.example.scheduler.dto.SchedulerSearchResponseDto;
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

    @PostMapping()
    public ResponseEntity<SchedulerResponseDto> addSchedule(@RequestBody SchedulerRequestDto dto) {
        //serviceLayer 호출 응답
        return new ResponseEntity<>(schedulerservice.addSchedule(dto), HttpStatus.CREATED);
    }

    @GetMapping()//부분구현
    public List<SchedulerSearchResponseDto> findSchedules(@RequestBody SchedulerSearchRequestDto dto){

        return schedulerservice.findSchedules(dto);
    }

    /*@GetMapping("/{id}") 고장
    public ResponseEntity<SchedulerSearchResponseDto> findSchedulerById(@PathVariable Long id){
        return new ResponseEntity<>(SchedulerService.findSchedulerById(id),HttpStatus.Ok);
    }*/



}
