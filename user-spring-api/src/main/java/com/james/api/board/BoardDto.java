package com.james.api.board;

import com.james.api.article.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class BoardDto {
    private Long id;
    private String boardName;
    private String boardType;

    @Builder.Default    // = List를 디폴트 타입으로 준다.
    private List<Article> article = new ArrayList<>();

}
