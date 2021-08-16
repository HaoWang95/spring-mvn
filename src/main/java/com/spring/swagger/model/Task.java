package com.spring.swagger.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString @NoArgsConstructor @AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "completed")
    private Boolean completed;


    public Task(String title, String content){
        this.title = title;
        this.content = content;
        this.completed = false;
    }
}
