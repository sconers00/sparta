package com.example.scheduler2.controller;

import com.example.scheduler2.dto.LogInRequestDto;
import com.example.scheduler2.dto.LogInResponseDto;
import com.example.scheduler2.dto.MemberRequestDto;
import com.example.scheduler2.dto.MemberResponseDto;
import com.example.scheduler2.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    @PostMapping("/signIn")//멤버등록
    public ResponseEntity<MemberResponseDto> signIn(@RequestBody @Valid MemberRequestDto requestDto){
        MemberResponseDto memberResponseDto = memberService.save(
                requestDto.getUsername(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );
        return new ResponseEntity<>(memberResponseDto, HttpStatus.CREATED);
    }
    @GetMapping//멤버 전체 조회
    public ResponseEntity<List<MemberResponseDto>> findAll(){
        List<MemberResponseDto> memberResponseDtoList = memberService.findAll();
        return new ResponseEntity<>(memberResponseDtoList,HttpStatus.OK);
    }
    @GetMapping("/{userid}")//단일 멤버 조회
    public ResponseEntity<MemberResponseDto> findMemberByUserid(@PathVariable @NotNull @Min(1) Long userid){
        MemberResponseDto memberResponseDto = memberService.findMemberByUserid(userid);
        return new ResponseEntity<>(memberResponseDto,HttpStatus.OK);
    }
    @PatchMapping("/{userid}")//멤버 정보 수정
    public ResponseEntity<Void> updateMember(@PathVariable @NotNull @Min(1) Long userid, @RequestBody @Valid MemberRequestDto requestDto){
        memberService.updateMember(userid, requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{userid}")//멤버 삭제
    public ResponseEntity<Void> deleteMember(@PathVariable @NotNull @Min(1) Long userid){
        memberService.deleteMember(userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/logIn")//로그인 기능
    public ResponseEntity<Void> login(@RequestBody @Valid LogInRequestDto dto, HttpServletRequest request) {
        LogInResponseDto responseDto = memberService.login(dto.getEmail(), dto.getPassword());
        Long userid=responseDto.getUserid();
        HttpSession session = request.getSession();// 회원 정보 조회
        MemberResponseDto loginUser = memberService.findMemberByUserid(userid);
        session.setAttribute("userid", loginUser);   // Session에 로그인 회원 정보를 저장한다.
        return new ResponseEntity<>(HttpStatus.OK);
    }

}