package com.dev.toy.entity;

import com.dev.toy.dto.BoardDto;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@Builder
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
    @JoinColumn(name = "member_id")
    private Member member;



    public void update(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
    }
}
