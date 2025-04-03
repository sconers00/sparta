package com.example.scheduler2.service;

import com.example.scheduler2.dto.MemberResponseDto;
import com.example.scheduler2.dto.ScheduleResponseDto;
import com.example.scheduler2.entity.Member;
import com.example.scheduler2.entity.Schedule;
import com.example.scheduler2.repository.MemberRepository;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberResponseDto save(String username, String email, String password){//회원 정보 저장
        Member member = new Member(username, email, password);
        memberRepository.save(member);
        return new MemberResponseDto(member.getUserid(), member.getUsername(), member.getEmail(), member.getCreatedAt(), member.getModifiedAt());
    }

    public List<MemberResponseDto> findAll() {
        return memberRepository.findAll().stream().map(MemberResponseDto::toDto).toList();
    }

    public MemberResponseDto findMemberByUserid(Long userid) {//id로 일정 조회
        Optional<Member> optionalMember = memberRepository.findMemberByUserid(userid);
        if(optionalMember.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exist userid = "+userid);
        }
        Member findMember = optionalMember.get();
        return new MemberResponseDto(findMember.getUserid(),findMember.getUsername(),findMember.getEmail(), findMember.getCreatedAt(), findMember.getModifiedAt());
    }

    @Transactional//회원정보 업데이트- 비밀번호까지 수정 가능
    public void updateMember(@NotNull @Min(1) Long userid, @NotBlank String username, @NotNull String email, @NotBlank @Size(min=6) String password) {
        Member findMember = memberRepository.findMemberByIdOrElseThrow(userid);
        findMember.updateMember(userid, username, email, password);
    }

    public void deleteMember(Long userid) {//회원 삭제
        Member findmember = memberRepository.findMemberByIdOrElseThrow(userid);
        memberRepository.delete(findmember);
    }
}
