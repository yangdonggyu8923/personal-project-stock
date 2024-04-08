package com.james.api.user;

import com.james.api.common.component.Messenger;
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

    @PostMapping(path = "/save")
    public ResponseEntity<Messenger> save(@RequestBody UserDto param) {
        log.info("입력받은 User 정보 : { }" + param);
        return ResponseEntity.ok(service.save(param));
    }

    // --------------- Query ----------------

    @PostMapping("/login")
    public ResponseEntity<Messenger> login(@RequestBody UserDto param) {
        log.info("입력받은 User 정보 : { }" + param);
        return ResponseEntity.ok(service.login(param));
    }


    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> findAll(Pageable pageable) {
        List<UserDto> ls = new ArrayList<>();
        service.findAll();
        return ResponseEntity.ok(new ArrayList<UserDto>());
    }
    @GetMapping("/detail")
    public ResponseEntity<Optional<UserDto>> findById(@RequestParam Long id) {
        log.info("입력받은 User 정보 : { }" + id);
        return ResponseEntity.ok(service.findById(id));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam Long id){
        log.info("입력받은 User 정보 : { }" + id);
        return ResponseEntity.ok(service.deleteById(id));
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count(PageRequestVo vo){
        return ResponseEntity.ok(service.count());
    }

    @PutMapping("/modify")
    public ResponseEntity<Messenger> modify(@RequestBody UserDto param) {
        log.info("입력받은 User 정보 : { }" + param);
        return ResponseEntity.ok(service.modify(param));
    }
    @PostMapping("/search")
    public ResponseEntity<List<UserDto>> findUsersByName(@RequestParam UserDto param) {
        log.info("입력받은 User 정보 : { }" + param);
        return ResponseEntity.ok((List<UserDto>) service.findUsersByName(param.getName()));
    }
//    @GetMapping("/findUsersByJob")
//    public ResponseEntity<Messenger> findUsersByJob(PageRequestVo vo) {
//        service.findUsersByJob(null);
//        return ResponseEntity.ok(new Messenger());
//    }

    //    @GetMapping("/exists")
//    public ResponseEntity<Messenger> existsById(PageRequestVo vo){
//        service.existsById(0L);
//        return ResponseEntity.ok(new Messenger());
//    }
}
