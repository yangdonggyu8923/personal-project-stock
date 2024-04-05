package com.james.api.board;

import com.james.api.board.service.BoardServiceImpl;
import com.james.api.common.component.MessengerVo;
import com.james.api.common.component.PageRequestVo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardServiceImpl service;
    @PostMapping("")
    public ResponseEntity<MessengerVo> save(PageRequestVo vo){
        service.save(null);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/findAll")
    public ResponseEntity<MessengerVo> findAll(PageRequestVo vo){
        service.findAll(null);
        return ResponseEntity.ok(new MessengerVo());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessengerVo> deleteById(PageRequestVo vo){
        service.deleteById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<MessengerVo> findById(PageRequestVo vo){
        service.findById(0L);
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
