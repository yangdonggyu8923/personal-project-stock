package com.james.api.board.service;

import com.james.api.board.model.BoardDto;
import com.james.api.board.repository.BoardRepository;
import com.james.api.common.component.Messenger;
import com.james.api.common.component.PageRequestVo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService{

    private static BoardRepository repository;


    @Override
    public Messenger save(BoardDto t) {
        entityToDto((repository.save(dtoToEntity(t))));
        return new Messenger();
    }


    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return new Messenger();
    }

    @Override
    public Messenger modify(BoardDto boardDto) {
        return null;
    }

    @Override
    public List<BoardDto> findAll() {
        repository.findAll();
        return new ArrayList<>();
    }

    @Override
    public Optional<BoardDto> findById(Long id) {
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

