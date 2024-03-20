package com.james.api.user;

import com.james.api.enums.Messenger;
import com.james.api.menu.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public Map<String, ?> login(@RequestBody Map<?, ?> paramMap){
        Map<String, String> map = new HashMap<>();
        String username = (String) paramMap.get("username");
        String password = (String) paramMap.get("password");
        System.out.println("리퀘스트가 가져온 아이디 : " + username +"\n리퀘스트가 가져온 비밀번호 : " + password);
        map.put("username" , username);
        map.put("password" , password);
        return map;
    }
    public Map<String, ?> delete(@RequestBody Map<?, ?> paramMap) {
        return null;
    }

    public Map<String, ?> addUsers() {
        return null;
    }

    public Map<String, ?> save(@RequestBody Map<?, ?> paramMap) {
        return null;
    }

    public Map<String, ?> findAll() {
        return null;
    }
    public Map<String, ?> findById(@RequestBody Map<?, ?> paramMap){
        return null;
    }
    public Map<String, ?> changePassword(@RequestBody Map<?, ?> paramMap){
        return null;
    }
    public Map<String, ?> findUsersByName(@RequestBody Map<?, ?> paramMap) {
        return null;
    }
    public Map<String, ?> findUsersByNameFromMap(@RequestBody Map<?, ?> paramMap) {
        return null;
    }
    public Map<String, ?> findUsersByJob(@RequestBody Map<?, ?> paramMap) {

        return null;
    }
    public Map<String, ?> findUsersByJobFromMap(@RequestBody Map<?, ?> paramMap) {
        return null;
    }

    public Map<String, ?> getUsersMap() {
        return null;
    }

    public Map<String, ?> count() {
        return null;
    }
    public Map<String, ?> getOne(@RequestBody Map<?, ?> paramMap) {
        return null;
    }
    public Map<String, ?> existsById(@RequestBody Map<?, ?> paramMap) {
        return null;
    }

    public Map<String, ?> findUsers() throws SQLException {
        return null;
    }

    public Messenger createTable() throws SQLException {
        return null;
    }

    public Messenger deleteTable() throws SQLException {
        return null;
    }

    public Messenger insertData(@RequestBody Map<?, ?> paramMap) throws SQLException {
        return null;
    }

    public Map<String, ?> sqlClose() throws SQLException {
        return null;
    }

    public Map<String, ?> insertMenuData(@RequestBody Map<?, ?> paramMap) throws SQLException {
        return null;
    }

    public Messenger createMenuTable() throws SQLException {
        return null;
    }

    public Messenger deleteMenuTable() throws SQLException {
        return null;
    }

}
