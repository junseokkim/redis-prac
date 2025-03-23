package com.kt.redis.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // 실사용에서는 DB 조회 로직이 들어갈 자리
    @Cacheable(value = "user", key = "#id")
    public String getUserById(String id) {
        System.out.println("DB에서 사용자 정보 조회: " + id);
        return "user-" + id; // 테스트용 리턴값
    }

    @CacheEvict(value = "user", key = "#id")
    public void evictUserCache(String id) {
        System.out.println("캐시 제거: " + id);
    }
}