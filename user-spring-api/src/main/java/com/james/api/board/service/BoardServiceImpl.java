package com.james.api.board.service;

import com.james.api.board.model.BoardDto;
import com.james.api.board.repository.BoardRepository;
import com.james.api.common.component.PageRequestVo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService{

    private static BoardRepository repository;


    @Override
    public BoardDto save(BoardDto t) {
        return entityToDto(Optional.of(repository.save(dtoToEntity(t))));
    }

    @Override
    public String insertMany() {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<BoardDto> findAll(PageRequestVo vo) {
        return null;
    }

    @Override
    public Optional<BoardDto> findById(Long id) {
        return Optional.of(entityToDto(repository.findById(id)));
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

