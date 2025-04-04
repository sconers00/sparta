package com.example.scheduler2.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity{//일정용

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity=Member.class)
    @JoinColumn(name="member_userId")
    private Member member;//유저 고유 id



    @Column(nullable=false)
    private String title;

    private String contents;

    public Schedule(){
    }

    public Schedule(Member member, String title, String contents){//통상
    this.member=member;//유저 고유 id
    this.title=title;
    this.contents=contents;
    }

    public void updateSchedule(Long id, String title, String contents) {//업데이트용
        this.id=id;//일정 고유 id
        this.title=title;
        this.contents=contents;
    }
}
