package com.example.scheduler2.repository;

import com.example.scheduler2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findMemberByUserid(Long userid);
    default Member findMemberByIdOrElseThrow(Long userid) {
        return findMemberByUserid(userid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist userid =" + userid));
    }
}