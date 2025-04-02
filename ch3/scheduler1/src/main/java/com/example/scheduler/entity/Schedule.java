package com.example.scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String name;
    private String todo;
    private String pswd;
    private String postdate;
    private String editdate;

    public Schedule(String name, String todo,String pswd){//일정 입력용
        this.name=name;
        this.todo=todo;
        this.pswd=pswd;
    }
    public Schedule(Long id, String name, String todo, String postdate, String editdate){//일반용
        this.id=id;
        this.name=name;
        this.todo=todo;
        this.postdate=postdate;
        this.editdate=editdate;
    }
}
