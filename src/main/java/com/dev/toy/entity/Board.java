package com.dev.toy.entity;

import com.dev.toy.dto.BoardDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Board extends BaseEntity {

    @Id
    @GeneratedValue
    private Long board_idx;

    private String title;

    private String member_id;

    private String content;

    private int view;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    @Builder
    private Board(String title, String member_id, String content, int view) {
        this.title = title;
        this.member_id = member_id;
        this.content = content;
        this.view = view;
    }

    public void update(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
    }
}
