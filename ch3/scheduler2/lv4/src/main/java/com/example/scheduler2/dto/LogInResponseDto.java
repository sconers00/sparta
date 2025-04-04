package com.example.scheduler2.dto;

import lombok.Getter;

@Getter
public class LogInResponseDto {
    private final String email;
    private final Long userid;
    public LogInResponseDto(String email, Long userid){
        this.email=email;
        this.userid=userid;
    }
}
