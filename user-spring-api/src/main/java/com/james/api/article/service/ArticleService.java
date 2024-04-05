package com.james.api.article.service;


import com.james.api.article.model.Article;
import com.james.api.article.model.ArticleDto;
import com.james.api.common.service.CommandService;
import com.james.api.common.service.QueryService;

import java.util.Optional;


public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {

    default Article dtoToEntity(ArticleDto dto){   //Dto를 Entity로 바꾸는 것

        return Article.builder().build();
    }

    default ArticleDto entityToDto(Optional<Article> optional){   // Entity를 Dto로 바꾸는 것
        return ArticleDto.builder().build();
    }


}
