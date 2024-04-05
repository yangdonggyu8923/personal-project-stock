package com.james.api.common.service;

import com.james.api.common.component.MessengerVo;

public interface CommandService<T> {

    T save (T t);
    String insertMany();
    void deleteById(Long id);

}
