package com.spring.swagger.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "createdAt")
    @CreatedDate
    private LocalDate createdAt;

    @Column(name = "lastModifiedAt")
    @LastModifiedDate
    private LocalDate lastModifiedAt;


    public Task(String title, String content){
        this.title = title;
        this.content = content;
        this.completed = false;
    }

    // We are using hibernate, the prePersist and preUpdate annotation can generate the value automatically
    @PrePersist
    public void prePersist(){
        if(createdAt == null){
            createdAt = LocalDate.now();
        }
        if(lastModifiedAt == null){
            lastModifiedAt = LocalDate.now();
        }
    }

    @PreUpdate
    public void preUpdate(){
        lastModifiedAt = LocalDate.now();
    }
}
