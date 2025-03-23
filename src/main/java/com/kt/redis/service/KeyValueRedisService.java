package com.kt.redis.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class KeyValueRedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public KeyValueRedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * Redis에 데이터 저장
     * @param key   Redis key
     * @param value 저장할 값 (Object 형태로 넣고 JSON으로 저장됨)
     */
    public void save(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * Redis에서 데이터 조회
     * @param key 조회할 key
     * @return 저장된 값 (JSON → Object 자동 역직렬화)
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 해당 key 삭제
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * key가 존재하는지 확인
     */
    public boolean hasKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }
}