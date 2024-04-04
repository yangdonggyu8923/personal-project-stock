package com.james.api.article;


import com.james.api.common.command.CommandService;
import com.james.api.common.query.QueryService;

import java.util.Optional;


public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {

    default Article dtoToEntity(ArticleDto dto){   //Dto를 Entity로 바꾸는 것

        Article article = Article.builder()

                .content(dto.getContent())
                .build();

        return article;
    }

    default Optional<ArticleDto> entityToDto(Article ent){   // Entity를 Dto로 바꾸는 것
        ArticleDto dto = ArticleDto.builder()

                .content(ent.getContent())
                .build();

        return Optional.ofNullable(dto);
    }


}
