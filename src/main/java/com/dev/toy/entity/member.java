package com.dev.toy.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@ToString
public class member {

    @Id @GeneratedValue
    private Long member_idx;

    private String member_id;

    private String member_name;

}
