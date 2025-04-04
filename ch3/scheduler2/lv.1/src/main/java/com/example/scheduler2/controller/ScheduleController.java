package com.example.scheduler2.controller;

import com.example.scheduler2.dto.ScheduleRequestDto;
import com.example.scheduler2.dto.ScheduleResponseDto;
import com.example.scheduler2.dto.ScheduleUpdateRequestDto;
import com.example.scheduler2.service.ScheduleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/scheduler")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedule")//일정등록
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody @Valid ScheduleRequestDto requestDto){
        ScheduleResponseDto scheduleResponseDto = scheduleService.save(
                requestDto.getUsername(),
                requestDto.getTitle(),
                requestDto.getContents()
        );
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }
    @GetMapping("/schedule/{id}")//단건조회
    public ResponseEntity<ScheduleResponseDto>findById(@PathVariable @NotNull @Min(1) Long id){
        ScheduleResponseDto scheduleResponseDto= scheduleService.findById(id);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }
    @GetMapping("/schedule")//전체조회
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();
        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }
    @PatchMapping("/schedule/{id}")//일정 수정(제목, 내용)
    public ResponseEntity<Void> updateSchedule(@PathVariable @NotNull @Min(1) Long id, @RequestBody @Valid ScheduleUpdateRequestDto requestDto){
        scheduleService.updateSchedule(id, requestDto.getTitle(), requestDto.getContents());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/schedule/{id}")//일정 삭제
    public ResponseEntity<Void> deleteSchedule(@PathVariable @NotNull @Min(1) Long id){
        scheduleService.deleteSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
