package com.example.scheduler2.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity{//일정용
//username, title, contents
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String username;
    @Column(nullable=false)
    private String title;
    private String contents;

    public Schedule(){
    }

    public Schedule(String username, String title, String contents){
    this.username=username;
    this.title=title;
    this.contents=contents;
    }

    public void updateSchedule(Long id, String title, String contents) {
        this.id=id;
        this.title=title;
        this.contents=contents;
    }
}
