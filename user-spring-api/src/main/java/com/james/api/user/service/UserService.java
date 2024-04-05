package com.james.api.user.service;
import com.james.api.common.service.CommandService;
import com.james.api.common.service.QueryService;
import com.james.api.user.model.User;
import com.james.api.user.model.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService extends CommandService<UserDto>, QueryService<UserDto> {

    default User dtoToEntity(UserDto dto) {
        return User.builder().build();
    }
    default UserDto entityToDto(Optional<User> optional) {
        return UserDto.builder().build();
    }

    // command
    String updatePassword(User user);

    // query
    List<?> findUsersByName(String name);
    List<?> findUsersByJob(String job);
}
