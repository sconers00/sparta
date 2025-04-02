package com.example.scheduler2.dto;

import com.example.scheduler2.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String username;
    private final String title;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public ScheduleResponseDto(Long id, String username, String title, String contents, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.username= username;
        this.title = title;
        this.contents = contents;
        this.createdAt= createdAt;
        this.modifiedAt= modifiedAt;
    }
    public static ScheduleResponseDto toDto(Schedule schedule){//전체조회용
        return new ScheduleResponseDto(schedule.getId(), schedule.getUsername(), schedule.getTitle(), schedule.getContents(), schedule.getCreatedAt(), schedule.getModifiedAt());
    }
}
