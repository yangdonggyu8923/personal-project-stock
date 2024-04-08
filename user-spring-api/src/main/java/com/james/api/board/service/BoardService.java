package com.james.api.board.service;

import com.james.api.board.model.Board;
import com.james.api.board.model.BoardDto;
import com.james.api.common.service.CommandService;
import com.james.api.common.service.QueryService;
import com.james.api.user.model.User;
import com.james.api.user.model.UserDto;

import java.util.Optional;

public interface BoardService extends CommandService<BoardDto>, QueryService<BoardDto> {

    default Board dtoToEntity(BoardDto dto) {
        return Board.builder().build();
    }

    default BoardDto entityToDto(Board board) {
        return BoardDto.builder().build();
    }
}
