package com.example.scheduler2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MemberRequestDto {

    @NotBlank
    @Size(min=4,max=12)
    private final String username;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z_0-9]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    private final String email;
    @NotBlank
    @Size(min=6)
    private final String password;

    public MemberRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}