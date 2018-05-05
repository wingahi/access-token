package cn.wgh.token.redis.protocol.storage.impl;

import cn.wgh.token.base.storage.api.DataStorageApi;
import cn.wgh.token.redis.protocol.utils.RedisUtilsApi;

public class DataStorageUtils implements DataStorageApi {

	private RedisUtilsApi redisUtilsApi;
	

	public DataStorageUtils(RedisUtilsApi redisUtilsApi) {
		super();
		this.redisUtilsApi = redisUtilsApi;
	}

	public void save(String key, Object data) {
		redisUtilsApi.set(key, data);
	}

	public void save(String key, Object data, int seconds) {
		redisUtilsApi.set(key, data);
		redisUtilsApi.expired(key, seconds);
	}

	public void save(String key, String subKey, String data, long timestamp) {
		redisUtilsApi.hset(key, subKey, data);
		redisUtilsApi.expireAt(key, timestamp);
	}

	public void setExpireTime(String key, int seconds) {
		redisUtilsApi.expired(key, seconds);
	}

	public void setExpireTime(String key, long timestamp) {
		redisUtilsApi.expireAt(key, timestamp);
	}

	public Object get(String key) {
		return redisUtilsApi.get(key);
	}

	public Object get(String key, String subKey) {
		return redisUtilsApi.hget(key, subKey);
	}

	public void save(String key, String subKey, String data, int seconds) {
		redisUtilsApi.hset(key, subKey, data);
		redisUtilsApi.expired(key, seconds);
	}



}
