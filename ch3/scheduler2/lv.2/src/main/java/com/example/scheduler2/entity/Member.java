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

    public Member(){
    }

    public Member(String username, String email){
        this.username=username;
        this.email=email;
    }

    public void updateMember(Long userid, String username, String email) {
        this.userid=userid;
        this.username=username;
        this.email=email;
    }
}
