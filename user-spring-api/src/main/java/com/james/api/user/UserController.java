package com.james.api.user;

import com.james.api.common.component.MessengerVo;
import com.james.api.common.component.PageRequestVo;
import com.james.api.user.model.UserDto;
import com.james.api.user.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping("api/users")
@Slf4j
public class UserController {
    private final UserServiceImpl service;

    // --------------- Command ----------------

    @PostMapping(path = "/join")
    public ResponseEntity<MessengerVo> save(@RequestBody UserDto dto) {
        log.info("입력받은 User 정보 : {}" + dto);
        service.save(dto);
//        User newUser = repository.save(User.builder()
//                .username((String) paramMap.get("username"))
//                .password((String) paramMap.get("password"))
//                .name((String) paramMap.get("name"))
//                .phone((String) paramMap.get("phone"))
//                .job((String) paramMap.get("job"))
//                .build());
        return ResponseEntity.ok(MessengerVo.builder()
                .message("SUCCESS")
                .code("200")
                .build());
    }

    // --------------- Query ----------------

    @PostMapping("/login")
    public ResponseEntity<MessengerVo> login(@RequestBody Map<String, UserDto> paraMap) { // requestbody = 프론트의 data
        Map<String, MessengerVo> response = new HashMap<>();

        String username = String.valueOf(paraMap.get("username"));

        return ResponseEntity.ok(new MessengerVo());
    }



    @GetMapping("/all-users")
    public ResponseEntity<List<UserDto>> findAll(Pageable pageable) {
        List<UserDto> ls = new ArrayList<>();
        service.findAll(null);
        return ResponseEntity.ok(new ArrayList<UserDto>());
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<UserDto>> findById(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        service.findById(0L);
        return ResponseEntity.ok(Optional.of(new UserDto()));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessengerVo> deleteById(PageRequestVo vo){
        service.deleteById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/count")
    public ResponseEntity<MessengerVo> count(PageRequestVo vo){
        service.count();
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<MessengerVo> existsById(PageRequestVo vo){
        service.existsById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }

}
