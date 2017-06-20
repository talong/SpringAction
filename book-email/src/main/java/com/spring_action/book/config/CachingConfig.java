package com.spring_action.book.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching   //启用缓存
public class CachingConfig {

	@Bean
	public CacheManager cacheManager(RedisTemplate redisTemplate) {   //声明缓存管理器
		return new RedisCacheManager(redisTemplate);  //redis缓存管理器
	}
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {  //redis连接工厂Bean
		JedisConnectionFactory jedisConnectionFactory = 
				new JedisConnectionFactory();
		jedisConnectionFactory.afterPropertiesSet();
		return jedisConnectionFactory;
	}
	
	@Bean
	public RedisTemplate<String, String> redisTemplate(
			RedisConnectionFactory redisCF) {
		RedisTemplate<String, String> redisTemplate =
				new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(redisCF);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
	
	
	
}
