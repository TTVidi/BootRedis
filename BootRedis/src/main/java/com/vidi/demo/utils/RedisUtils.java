package com.vidi.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;

/**
 * @Author : Vidi
 * @Date : 2018/1/3 16:48
 * @Descripton : Redis Util Class
 */
@SuppressWarnings("unchecked")
@Component
public class RedisUtils<T> {

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 批量删除keys对应的values
	 *
	 * @param keys
	 */
	public void remove(final String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}

	/**
	 * 批量删除keys
	 *
	 * @param pattern
	 */
	public void removePattern(final String... pattern) {
		Set<Serializable> keys = redisTemplate.keys(pattern);
		if (keys.size() > 0) {
			redisTemplate.delete(keys);
		}
	}

	/**
	 * 删除key所对应的value
	 *
	 * @param key
	 */
	public void remove(final String key) {
		if (exist(key)) {
			redisTemplate.delete(key);
		}
	}

	/**
	 * 判断redis中是否有key对应的value
	 *
	 * @param key
	 * @return
	 */
	public boolean exist(final String key) {
		return redisTemplate.hasKey(key);
	}


	/**
	 * 读取Redis缓存
	 *
	 * @param key
	 * @return
	 */
	public T get(final String key) {
		ValueOperations<Serializable, T> operations = redisTemplate.opsForValue();
		return operations.get(key);
	}

	/**
	 * 写入Redis缓存
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(final String key, T value) {
		boolean result = false;
		try {
			ValueOperations<Serializable, T> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			result = true;
		} catch (Exception e) {
			logger.error(e.getMessage().toString());
		}
		return result;
	}

	/**
	 * 加上超时时间写入Redis缓存
	 *
	 * @param key
	 * @param value
	 * @param expireTime
	 * @return
	 */
	public boolean set(final String key, T value, Long expireTime) {
		boolean result = false;
		try {
			ValueOperations<Serializable, T> operations = redisTemplate.opsForValue();
			operations.set(key, value, expireTime);
			result = true;
		} catch (Exception e) {
			logger.error(e.getMessage().toString());
		}
		return result;
	}

}
