package com.james.api.article.service;


import com.james.api.article.model.Article;
import com.james.api.article.model.ArticleDto;
import com.james.api.board.model.Board;
import com.james.api.common.service.CommandService;
import com.james.api.common.service.QueryService;
import com.james.api.user.model.User;


public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {

    default Article dtoToEntity(ArticleDto dto){   //Dto를 Entity로 바꾸는 것

        return Article.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(User.builder()
                        .id(dto.getWriter())
                        .build())
                .board(Board.builder()
                        .id(dto.getBoard())
                        .build())
                .build();
    }

    default ArticleDto entityToDto(Article article){   // Entity를 Dto로 바꾸는 것
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .writer(article.getWriter().getId())
                .board(article.getBoard().getId())
                .regDate(article.getRegDate().toString())
                .modDate(article.getModDate().toString())
                .build();
    }


}
