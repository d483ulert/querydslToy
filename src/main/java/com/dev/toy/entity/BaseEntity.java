package com.dev.toy.entity;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime create_date;

    @LastModifiedDate
    private LocalDateTime update_date;

    @CreatedDate
    @Column(updatable = false)
    private String created_member;

    @LastModifiedBy
    private String modified_member;


    @PrePersist
    public void timePersist(){
        create_date= LocalDateTime.now();
    }

    @PreUpdate
    public void updatePersist(){
        update_date= LocalDateTime.now();
    }
}
