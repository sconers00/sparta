package com.example.scheduler2.controller;

import com.example.scheduler2.dto.MemberRequestDto;
import com.example.scheduler2.dto.MemberResponseDto;
import com.example.scheduler2.service.MemberService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponseDto> signIn(@RequestBody @Valid MemberRequestDto requestDto){
        MemberResponseDto memberResponseDto = memberService.save(
                requestDto.getUsername(),
                requestDto.getEmail()
        );
        return new ResponseEntity<>(memberResponseDto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> findAll(){
        List<MemberResponseDto> memberResponseDtoList = memberService.findAll();
        return new ResponseEntity<>(memberResponseDtoList,HttpStatus.OK);
    }
    @GetMapping("/{userid}")
    public ResponseEntity<MemberResponseDto> findMemberByUserid(@PathVariable @NotNull @Min(1) Long userid){
        MemberResponseDto memberResponseDto = memberService.findMemberByUserid(userid);
        return new ResponseEntity<>(memberResponseDto,HttpStatus.OK);
    }
    @PatchMapping("/{userid}")
    public ResponseEntity<Void> updateMember(@PathVariable @NotNull @Min(1) Long userid, @RequestBody @Valid MemberRequestDto requestDto){
        memberService.updateMember(userid, requestDto.getUsername(), requestDto.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{userid}")
    public ResponseEntity<Void> deleteMember(@PathVariable @NotNull @Min(1) Long userid){
        memberService.deleteMember(userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
