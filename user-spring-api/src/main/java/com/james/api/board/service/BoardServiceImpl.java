package com.james.api.board.service;

import com.james.api.board.model.BoardDto;
import com.james.api.board.repository.BoardRepository;
import com.james.api.common.component.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository repository;


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
        return repository.findAll().stream()
                .map(i->entityToDto(i))
                .toList();
    }

    @Override
    public Optional<BoardDto> findById(Long id) {
        return repository.findById(id).stream().map(i->entityToDto(i)).findAny();
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }
}

