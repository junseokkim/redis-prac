package com.kt.redis.controller;

import com.kt.redis.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 캐시 테스트용
    @GetMapping("/{id}")
    public ResponseEntity<String> getUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // 캐시 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> evictCache(@PathVariable String id) {
        userService.evictUserCache(id);
        return ResponseEntity.ok("캐시 삭제 완료");
    }
}
