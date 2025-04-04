package com.example.scheduler2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class MemberRequestDto {

    @NotBlank
    private final String username;
    @NotNull
    private final String email;

    public MemberRequestDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}