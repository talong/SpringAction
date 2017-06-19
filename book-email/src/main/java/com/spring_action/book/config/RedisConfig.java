package com.spring_action.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

public class RedisConfig {

	/**
	 * 配置redis
	 * @return
	 */
	@Bean
	public RedisConnectionFactory redisCF() {
		JedisConnectionFactory cf = new JedisConnectionFactory();
		cf.setHostName("redis-server");
		cf.setPort(6379);
		return cf;
	}
}
