package com.example.scheduler2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LogInRequestDto {
    @NotBlank
    private final String email;
    @NotNull
    private final String password;
}
