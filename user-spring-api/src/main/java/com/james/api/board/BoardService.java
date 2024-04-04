package com.james.api.board;

import com.james.api.article.Article;
import com.james.api.article.ArticleDto;
import com.james.api.common.command.CommandService;
import com.james.api.common.query.QueryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BoardService extends CommandService, QueryService {

    default Article dtoToEntity(ArticleDto dto){   //Dto를 Entity로 바꾸는 것

        Article article = Article.builder()

                .content(dto.getContent())
                .build();

        return article;
    }

    default ArticleDto entityToDto(Article ent){   // Entity를 Dto로 바꾸는 것
        ArticleDto dto = ArticleDto.builder()

                .content(ent.getContent())
                .build();

        return dto;
    }

}
