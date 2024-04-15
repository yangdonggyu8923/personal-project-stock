package com.james.api.article.model;

import com.james.api.board.model.Board;
import com.james.api.common.model.BaseEntity;
import com.james.api.user.model.User;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
@ToString(exclude = {"id"})
@Builder
@Entity(name = "articles")

public class Article extends BaseEntity {
    @Id
    @Column(name = "article_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private User writer;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

//    public static Article of(String title, String content){
//        Article article = new Article();
//        article.title = title;
//        article.content = content;
//        return article;
//    }
}
