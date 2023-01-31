package com.dev.toy.entity;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    private Long member_idx;


    @NotNull
    private String member_id;

    @NotNull
    private String member_name;

    @NotNull
    private String member_pw;

    @NotNull
    private LocalDateTime birth_day;

    @OneToMany(mappedBy = "member")
    private List<Board> board = new ArrayList<>();

    @Builder
    public Member(String member_id, String member_name, String member_pw,LocalDateTime birth_day) {
        this.member_id = member_id;
        this.member_name = member_name;
        this.member_pw = member_pw;
        this.birth_day = birth_day;
    }
}
