package com.james.api.user;
import com.james.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000") //1번 문 열어주기
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl service;
    private final UserRepository repository;

    @PostMapping("/api/login")
        public Map<String, ?> login(@RequestBody Map<?, ?> paraMap){ // requestbody = 프론트의 data
        Map<String, Messenger> map = new HashMap<>();
        String username = (String) paraMap.get("username");
        String password = (String) paraMap.get("password");
        User optUser = repository.findByUsername(username).orElse(null);

        if(optUser == null){
            map.put("message", Messenger.FAIL);
        }
        else if(!optUser.getPassword().equals(password)){
            map.put("message", Messenger.WRONG_PASSWORD);
        }
        else {
            map.put("message", Messenger.SUCCESS);
        }
        return map;
    }

    @PostMapping(path = "/api/users")
    public Map<String, ?> join(@RequestBody Map<String, ?> paramMap){
        Map<String, Messenger> map = new HashMap<>();
        User newUser = repository.save(User.builder()
                .username((String) paramMap.get("username"))
                .password((String) paramMap.get("password"))
                .checkPassword((String) paramMap.get("checkPassword"))
                .name((String) paramMap.get("name"))
                .phone((String) paramMap.get("phone"))
                .job((String) paramMap.get("job"))
                .height(Double.parseDouble((String) paramMap.get("height")))
                .weight(Double.parseDouble((String) paramMap.get("weight")))
                .build());
        System.out.println("DB에 저장된 User 정보: " + newUser);
        map.put("result",Messenger.SUCCESS);
        return map;
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/api/all-users")
    public Map<String, ?> findAll(){
        Map<String, Object> map = new HashMap<>();
//        map.put("message", Messenger.SUCCESS);
        List<User> list = new ArrayList<>();
        list = repository.findAll();
        map.put("result", list);
        return map;
    }


    public Map<String, ?> save(@RequestBody Map<String, ?> paraMap) throws SQLException {
        System.out.println("\"아이디, 비밀번호, 비밀번호확인, 이름, 전화번호, 폰번호, 주소, 직업을 입력하세요\"");
        return null;
    }


    public Map<String, ?> findById(@RequestBody Map<String, ?> paraMap) {
        return null;
    }

    public Map<String, ?> updatePassword(@RequestBody Map<String, ?> paraMap) {

        return null;
    }

    public Map<String, ?> deleteUser(@RequestBody Map<String, ?> paraMap) {
        return null;
    }

    public Map<String, ?> existsById(@RequestBody Map<String, ?> paraMap) {
        return null;
    }

    public Map<String, ?> findUsersByName(@RequestBody Map<String, ?> paraMap) {
        return null;
    }

    public Map<String, ?> findUsersByNameFromMap(@RequestBody Map<String, ?> paraMap) {
        return null;
    }

    public Map<String, ?> findUsersByJob(@RequestBody Map<String, ?> paraMap) {
        return null;
    }

    public Map<String, ?> count() {
        return null;
    }

    public Map<String, ?> getOne(@RequestBody Map<String, ?> paraMap) {
        return null;
    }

    public Map<String, ?> getUserMap() {
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
    public Messenger insertData(Scanner sc) throws SQLException {
        return null;
    }
    public void sqlClose() throws SQLException {
        return;
    }
}
