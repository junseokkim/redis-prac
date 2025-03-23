package com.kt.redis.controller;

import com.kt.redis.service.KeyValueRedisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kv")
public class KeyValueController {

    private final KeyValueRedisService redisService;

    public KeyValueController(KeyValueRedisService redisService) {
        this.redisService = redisService;
    }

    // 저장 API → /kv/save?key=example&value=hello
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestParam String key, @RequestParam String value) {
        redisService.save(key, value);
        return ResponseEntity.ok("저장 완료");
    }

    // 조회 API → /kv/get?key=example
    @GetMapping("/get")
    public ResponseEntity<Object> get(@RequestParam String key) {
        Object value = redisService.get(key);
        return ResponseEntity.ok(value);
    }

    // 삭제 API → /kv/delete?key=example
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam String key) {
        redisService.delete(key);
        return ResponseEntity.ok("삭제 완료");
    }

    // 존재 여부 확인 API → /kv/has?key=example
    @GetMapping("/has")
    public ResponseEntity<Boolean> has(@RequestParam String key) {
        return ResponseEntity.ok(redisService.hasKey(key));
    }
}
