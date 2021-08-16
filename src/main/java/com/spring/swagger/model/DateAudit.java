package com.spring.swagger.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class DateAudit implements Serializable {

    @CreatedDate
    @Column(name = "createdAt", updatable = false)
    private LocalDate createdAt;

    @LastModifiedDate
    @Column(name = "updatedAt")
    private LocalDate updatedAt;

}
