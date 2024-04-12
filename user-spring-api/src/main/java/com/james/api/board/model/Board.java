package com.james.api.board.model;
import com.james.api.article.model.Article;
import com.james.api.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.apache.logging.log4j.util.Lazy;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
@ToString(exclude = {"id"})
@Entity(name="boards")
public class Board extends BaseEntity {
    @Id
    @Column(name = "board_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "board_name")
    private String boardName;
    @Column(name = "board_type")
    private String boardType;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> article;

    @Builder(builderMethodName = "builder")
    public Board(Long id, String boardName, String boardType) {
        this.id = id;
        this.boardName = boardName;
        this.boardType = boardType;
    }
}
