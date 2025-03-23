package com.kt.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    // RedisTemplate: Redis에 접근하는 핵심 클래스
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // Key는 문자열로 저장
        template.setKeySerializer(new StringRedisSerializer());

        // Value는 JSON 형태로 저장 (Java 객체 직렬화보다 호환성, 가독성 좋음)
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        return template;
    }
}