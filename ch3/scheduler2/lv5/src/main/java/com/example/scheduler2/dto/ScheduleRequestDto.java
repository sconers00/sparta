package com.example.scheduler2.dto;

import com.example.scheduler2.entity.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private final Member member;
    @NotBlank
    @Size(max=12)
    private final String title;
    private final String contents;

    public ScheduleRequestDto(Member member, String title, String contents) {
        this.member=member;
        this.title = title;
        this.contents = contents;
    }
}