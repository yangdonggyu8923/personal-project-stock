package com.james.api.article.service;
import com.james.api.article.model.ArticleDto;
import com.james.api.article.repository.ArticleRepository;
import com.james.api.common.component.Messenger;
import com.james.api.common.component.PageRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{

    private static ArticleRepository repository;

    @Override
    public Messenger save(ArticleDto t) {
        entityToDto((repository.save(dtoToEntity(t))));
        return new Messenger();
    }

    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return new Messenger();
    }

    @Override
    public Messenger modify(ArticleDto articleDto) {
        return null;
    }


    @Override
    public List<ArticleDto> findAll() {
        repository.findAll();
        return new ArrayList<>();
    }

    @Override
    public Optional<ArticleDto> findById(Long id) {
//        Optional.of(entityToDto(repository.findById(id)));
        return null;
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }
}


