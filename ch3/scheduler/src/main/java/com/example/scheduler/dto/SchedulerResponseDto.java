package com.example.scheduler.dto;

import com.example.scheduler.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SchedulerResponseDto {

    private final Long id;
    private final String name;
    private final String todo;
    private final String postdate;
    private final String editdate;

    public SchedulerResponseDto(Schedule schedule) {
        this.id=schedule.getId();
        this.name=schedule.getName();
        this.todo=schedule.getTodo();
        this.postdate=schedule.getPostdate();
        this.editdate=schedule.getEditdate();

    }

}
