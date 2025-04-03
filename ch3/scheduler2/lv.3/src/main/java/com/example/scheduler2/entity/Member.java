package com.example.scheduler2.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "member")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    @Column(nullable=false)
    private String username;
    @Column(nullable=false)
    private String email;
    @Column(nullable=false)
    private String password;

    public Member(){
    }

    public Member(String username, String email, String password){//통상
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public void updateMember(Long userid, String username, String email, String password) {//업데이트용
        this.userid=userid;
        this.username=username;
        this.email=email;
        this.password=password;
    }
}
