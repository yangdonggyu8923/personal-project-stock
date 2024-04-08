package com.james.api.common.service;

import com.james.api.common.component.PageRequestVo;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface QueryService<T> {
    List<T> findAll();
    Optional<T> findById(Long id);
    long count();
    Boolean existsById(Long id);
}
