package com.dev.toy.entity;

import com.dev.toy.dto.BoardDto;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="board")
public class Board extends BaseEntity implements Serializable {

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

    @Builder
    public Board(String title,String writer, String content, Integer view){
        this.title = title;
        this.writer =writer;
        this.content = content;
        this.view = view;
    }

    public void update(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
    }
}
