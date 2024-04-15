package com.james.api.user.service;

import com.james.api.common.component.Messenger;
import com.james.api.common.component.PageRequestVo;
import com.james.api.user.model.User;
import com.james.api.user.model.UserDto;
import com.james.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;


    @Override
    public Messenger save(UserDto t) {
        entityToDto(repository.save(dtoToEntity(t)));
        return Messenger.builder().message("SUCCESS").build();
    }

    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return Messenger.builder()
                .message(repository.findById(id).isPresent() ? "SUCCESS" : "FAILURE")
                .build();
    }

    @Override
    public Messenger modify(UserDto user) {
        repository.save(dtoToEntity(user));
        return Messenger.builder()
                .message("SUCCESS")
                .build();
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream().map(i->entityToDto(i)).toList();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
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

    @Override
    public List<?> findUsersByName(String name) {
        return null;
    }

    @Override
    public List<?> findUsersByJob(String job) {
        return null;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return repository.findByUsername(username);
    }


    // SRP에 따라 아이디 존재여부를 프론트에서 먼저 판단하고 넘어옴 (시큐리티)
    @Override
    public Messenger login(UserDto param) {
        return Messenger.builder()
                .message(findUserByUsername(param.getUsername())
                        .get() // 무조건 get이다 ( getOrElse = 없을수도있음 )
                        .getPassword()
                        .equals(param.getPassword()) ? "SUCCESS" : "FAILURE")
                .build();
    }
}
