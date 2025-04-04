package com.example.scheduler2.dto;

import com.example.scheduler2.entity.Member;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class MemberResponseDto {
    private final Long userid;
    @NotBlank
    private final String username;
    @NotBlank
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    public MemberResponseDto(Long userid, String username, String email, LocalDateTime createdAt, LocalDateTime modifiedAt){
        this.userid=userid;
        this.username=username;
        this.email=email;
        this.createdAt=createdAt;
        this.modifiedAt=modifiedAt;
    }
    public static MemberResponseDto toDto(Member member){//전체조회용
        return new MemberResponseDto(member.getUserid(), member.getUsername(), member.getEmail(), member.getCreatedAt(), member.getModifiedAt());
    }
}
