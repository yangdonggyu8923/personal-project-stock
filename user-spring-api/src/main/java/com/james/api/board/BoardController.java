package com.james.api.board;

import com.james.api.board.model.BoardDto;
import com.james.api.board.service.BoardServiceImpl;
import com.james.api.common.component.Messenger;
import com.james.api.common.component.PageRequestVo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping("/api/boards")
@Slf4j
public class BoardController {
    private final BoardServiceImpl service;
    @PostMapping("/save")
    public ResponseEntity<Messenger> save(@RequestBody BoardDto param) {
        log.info("입력받은 정보 : { }", param );
        return ResponseEntity.ok(service.save(param));

    }
    @GetMapping("/list")
    public ResponseEntity<List<BoardDto>> findAll(){
        log.info("입력받은 정보 : { }" );
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam Long id){
        log.info("입력받은 정보 : { }", id );
        return ResponseEntity.ok(service.deleteById(id));
    }
    @GetMapping("/detail")
    public ResponseEntity<Optional<BoardDto>> findById(@RequestParam Long id) {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(service.count());
    }
    @PutMapping("/modify")
    public ResponseEntity<Messenger> modify(@RequestBody BoardDto param) {
        log.info("입력받은 정보 : {}", param );
        return ResponseEntity.ok(service.modify(param));
    }

//    @GetMapping("/exists")
//    public ResponseEntity<Messenger> existsById(PageRequestVo vo){
//        service.existsById(0L);
//        return ResponseEntity.ok(new Messenger());
//    }
}
