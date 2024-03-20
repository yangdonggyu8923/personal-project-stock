package com.james.api.common;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequiredArgsConstructor
public class HomeController {
    @GetMapping("/")
    public String hello()
    {

        return "Welcome To Spring Boot - 9";
    }

    @PostMapping("/name")
    public Map<String, ?> name(@RequestBody Map<String, ?> map){
        String name = (String)map.get("name");
        System.out.println("리퀘스트가 가져온 이름 : " + name);
        Map<String, String> respMap = new HashMap<>();
        respMap.put("name", "환영합니다 " + name );
        return respMap;
    }
}
