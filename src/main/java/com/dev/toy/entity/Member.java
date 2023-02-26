package com.dev.toy.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@SuperBuilder
@Table(name="member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    private Long memberIdx;


    @NotNull
    private String member_id;

    @NotNull
    private String member_name;

    @NotNull
    private String member_pw;

    @NotNull
    private LocalDateTime birth_day;

}
