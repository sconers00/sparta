package com.example.scheduler.dto;


import com.example.scheduler.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SchedulerSearchResponseDto {

    private Long id;
    private String name;
    private String todo;
    private String postdate;
    private String editdate;

    public SchedulerSearchResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.todo = schedule.getTodo();
        this.postdate = schedule.getPostdate();
        this.editdate = schedule.getEditdate();
    }

}
