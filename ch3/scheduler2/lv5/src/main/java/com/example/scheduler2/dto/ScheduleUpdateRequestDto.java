package com.example.scheduler2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ScheduleUpdateRequestDto {

    @NotBlank
    @Size(max=12)
    private final String title;
    private final String contents;

    public ScheduleUpdateRequestDto(String title, String contents){
        this.title=title;
        this.contents=contents;
    }
}
