package com.james.api.article.service;


import com.james.api.article.model.Article;
import com.james.api.article.model.ArticleDto;
import com.james.api.common.service.CommandService;
import com.james.api.common.service.QueryService;



public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {

    default Article dtoToEntity(ArticleDto dto){   //Dto를 Entity로 바꾸는 것

        return Article.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }

    default ArticleDto entityToDto(Article article){   // Entity를 Dto로 바꾸는 것
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .writerId(article.getWriter().getId())
                .boardId(article.getBoard().getId())
                .regDate(article.getRegDate().toString())
                .modDate(article.getModDate().toString())
                .build();
    }


}
