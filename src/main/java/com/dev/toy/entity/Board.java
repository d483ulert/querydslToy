package com.dev.toy.entity;

import com.dev.toy.dto.BoardDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name="board")
public class Board extends BaseEntity  {

    @Id
    @GeneratedValue
    private Long boardIdx;

    private String title;

    private String writer;

    private String content;

    private Integer view;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;


    public void update(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
    }
}
