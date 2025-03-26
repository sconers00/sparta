package com.example.scheduler.dto;

import com.example.scheduler.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SchedulerSearchRequestDto {

    private String name;
    private String postdate;

    public SchedulerSearchRequestDto(Schedule schedule) {
        this.name=schedule.getName();
        this.postdate=schedule.getPostdate();
    }

}

