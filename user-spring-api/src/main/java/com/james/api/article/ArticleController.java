package com.james.api.article;

import com.james.api.article.model.ArticleDto;
import com.james.api.article.service.ArticleServiceImpl;
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
@RequestMapping("/api/articles")
@Slf4j
public class ArticleController {
    private final ArticleServiceImpl service;

    @PostMapping("/save")
    public ResponseEntity<Messenger> save(@RequestBody ArticleDto param){
        log.info("입력받은 정보 : {}", param );
        return ResponseEntity.ok(service.save(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<ArticleDto>> findAll(){
        log.info(service.findAll().toString());
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Messenger> deleteById(@RequestParam Long id){
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.deleteById(id));
    }
    @GetMapping("/detail")
    public ResponseEntity<Optional<ArticleDto>> findById(@RequestBody Long id){
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count(){
        return ResponseEntity.ok(service.count());
    }
//    @GetMapping("/exists")
//    public ResponseEntity<Messenger> existsById(PageRequestVo vo){
//        service.existsById(0L);
//        return ResponseEntity.ok(new Messenger());
//    }
    @PutMapping("/modify")
    public ResponseEntity<Messenger> modify(@RequestBody ArticleDto param) {
        log.info("입력받은 정보 : {}", param );
        return ResponseEntity.ok(service.modify(param));
    }
}
