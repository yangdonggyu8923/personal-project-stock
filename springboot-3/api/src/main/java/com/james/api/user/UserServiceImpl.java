package com.james.api.user;

import com.james.api.common.AbstractService;
import com.james.api.common.UtilService;
import com.james.api.common.UtilServiceImpl;
import com.james.api.enums.Messenger;
import com.james.api.menu.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    @Override
    public String login(User user) {
        return null;
    }

    @Override
    public String addUsers() {
        return null;
    }

    @Override
    public String changePassword(User user) {
        return null;
    }

    @Override
    public List<?> findUsersByName(String name) {
        return null;
    }

    @Override
    public Map<String, ?> findUsersByNameFromMap(String name) {
        return null;
    }

    @Override
    public List<?> findUsersByJob(String job) {
        return null;
    }

    @Override
    public Map<String, ?> findUsersByJobFromMap(String job) {
        return null;
    }

    @Override
    public Map<String, ?> getUsersMap() {
        return null;
    }

    @Override
    public List<?> findUsers() throws SQLException {
        return null;
    }

    @Override
    public Messenger deleteTable() throws SQLException {
        return null;
    }

    @Override
    public Messenger createTable() throws SQLException {
        return null;
    }

    @Override
    public Messenger insertData(User user) throws SQLException {
        return null;
    }

    @Override
    public void sqlClose() throws SQLException {

    }

    @Override
    public Messenger insertMenuData(Menu menu) throws SQLException {
        return null;
    }

    @Override
    public Messenger createMenuTable() throws SQLException {
        return null;
    }

    @Override
    public Messenger deleteMenuTable() throws SQLException {
        return null;
    }
}
