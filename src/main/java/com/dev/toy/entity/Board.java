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

    private String writer;

    private String content;

    private int view;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    @Builder
    private Board(String title, String writer, String content, int view) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.view = view;
    }

    public void update(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
    }
}
