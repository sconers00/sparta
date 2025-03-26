package com.example.scheduler.dto;

import com.example.scheduler.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SchedulerResponseDto {

    private Long id;
    private String name;
    private String todo;
    private String pswd;
    private String postdate;
    private String editdate;

    public SchedulerResponseDto(Schedule schedule) {
        this.id=schedule.getId();
        this.name=schedule.getName();
        this.todo=schedule.getTodo();
        this.pswd=schedule.getPswd();
    }

}
