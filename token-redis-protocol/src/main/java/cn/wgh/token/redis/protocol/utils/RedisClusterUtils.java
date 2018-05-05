/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wgh.token.redis.protocol.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.SortingParams;
import redis.clients.util.SafeEncoder;
import org.springframework.util.SerializationUtils;

/**
 *
 * @author Administrator
 */
public class RedisClusterUtils implements RedisUtilsApi {

    protected JedisCluster jedisCluster;

    public RedisClusterUtils(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

   

    /**
     * 设置key的过期时间，以秒为单位
     *
     * @param String key
     * @param 时间 ,已秒为单位
     * @ 影响的记录数
     *
     */
    public long expired(String key, int seconds) {
        return jedisCluster.expire(key, seconds);
    }

    /**
     * 设置key的过期时间,它是距历元（即格林威治标准时间 1970 年 1 月 1 日的 00:00:00，格里高利历）的偏移量。
     *
     * @param String key
     * @param 时间 ,已秒为单位
     * @ 影响的记录数
     *
     */
    public long expireAt(String key, long timestamp) {

        return jedisCluster.expireAt(key, timestamp);
    }

   

    /**
     * 取消对key过期时间的设置
     *
     * @param key
     * @ 影响的记录数
     *
     */
    public long persist(String key) {
        return jedisCluster.persist(key);
    }

    /**
     * 删除keys对应的记录,可以是多个key
     *
     * @param String ... keys
     * @ 删除的记录数
     *
     */
    public long del(String... keys) {
        return jedisCluster.del(keys);
    }


    /**
     * 判断key是否存在
     *
     * @param String key
     * @ boolean
     *
     */
    public boolean exists(String key) {
        return jedisCluster.exists(key);
    }

 
    //*******************************************Hash*******************************************//
    /**
     * 从hash中删除指定的存储
     *
     * @param String key
     * @param String fieid 存储的名字
     * @ 状态码，1成功，0失败
     *
     */
    public long hdel(String key, String fieid) {

        long s = jedisCluster.hdel(key, fieid);

        return s;
    }

    public long hdel(String key) {

        long s = jedisCluster.del(key);

        return s;
    }

    /**
     * 测试hash中指定的存储是否存在
     *
     * @param String key
     * @param String fieid 存储的名字
     * @ 1存在，0不存在
     *
     */
    public boolean hexists(String key, String fieid) {
        //ShardedJedis jedisCluster = getShardedJedis();

        boolean s = jedisCluster.hexists(key, fieid);

        return s;
    }

    /**
     * 返回hash中指定存储位置的值
     *
     * @param String key
     * @param String fieid 存储的名字
     * @ 存储对应的值
     *
     */
    public String hget(String key, String fieid) {
        //ShardedJedis jedisCluster = getShardedJedis();

        String s = jedisCluster.hget(key, fieid);

        return s;
    }

    public byte[] hget(byte[] key, byte[] fieid) {
        //ShardedJedis jedisCluster = getShardedJedis();

        byte[] s = jedisCluster.hget(key, fieid);

        return s;
    }

    /**
     * 以Map的形式返回hash中的存储和值
     *
     * @param String key
     * @ Map<Strinig,String>
     *
     */
    public Map<String, String> hgetAll(String key) {
        Map<String, String> map = jedisCluster.hgetAll(key);
        return map;
    }

    /**
     * 添加一个对应关系
     *
     * @param String key
     * @param String fieid
     * @param String value
     * @ 状态码 1成功，0失败，fieid已存在将更新，也返回0 *
     */
    public long hset(String key, String fieid, String value) {
        long s = jedisCluster.hset(key, fieid, value);
        return s;
    }

    public long hset(String key, String fieid, Object value) {
        long s = jedisCluster.hset(key.getBytes(), fieid.getBytes(), SerializationUtils.serialize(value));
        return s;
    }

    /**
     * 添加对应关系，只有在fieid不存在时才执行
     *
     * @param String key
     * @param String fieid
     * @param String value
     * @ 状态码 1成功，0失败fieid已存 *
     */
    public long hsetnx(String key, String fieid, String value) {

        long s = jedisCluster.hsetnx(key, fieid, value);

        return s;
    }

    /**
     * 获取hash中value的集合
     *
     * @param String key
     * @ List<String>
     *
     */
    public List<String> hvals(String key) {
        //ShardedJedis jedisCluster = getShardedJedis();

        List<String> list = jedisCluster.hvals(key);

        return list;
    }

    /**
     * 在指定的存储位置加上指定的数字，存储位置的值必须可转为数字类型
     *
     * @param String key
     * @param String fieid 存储位置
     * @param String long value 要增加的值,可以是负数
     * @ 增加指定数字后，存储位置的值
     *
     */
    public long hincrby(String key, String fieid, long value) {

        long s = jedisCluster.hincrBy(key, fieid, value);

        return s;
    }

    /**
     * 返回指定hash中的所有存储名字,类似Map中的keySet方法
     *
     * @param String key
     * @ Set<String> 存储名称的集合
     *
     */
    public Set<String> hkeys(String key) {
        //ShardedJedis jedisCluster = getShardedJedis();

        Set<String> set = jedisCluster.hkeys(key);

        return set;
    }

    /**
     * 获取hash中存储的个数，类似Map中size方法
     *
     * @param String key
     * @ long 存储的个数
     *
     */
    public long hlen(String key) {
        //ShardedJedis jedisCluster = getShardedJedis();

        long len = jedisCluster.hlen(key);

        return len;
    }

    /**
     * 根据多个key，获取对应的value，返回List,如果指定的key不存在,List对应位置为null
     *
     * @param String key
     * @param String ... fieids 存储位置
     * @ List<String>
     *
     */
    public List<String> hmget(String key, String... fieids) {
        //ShardedJedis jedisCluster = getShardedJedis();

        List<String> list = jedisCluster.hmget(key, fieids);

        return list;
    }

    public List<byte[]> hmget(byte[] key, byte[]... fieids) {
        //ShardedJedis jedisCluster = getShardedJedis();

        List<byte[]> list = jedisCluster.hmget(key, fieids);

        return list;
    }

    /**
     * 添加对应关系，如果对应关系已存在，则覆盖
     *
     * @param Strin key
     * @param Map
     * <String,String> 对应关系
     * @ 状态，成功返回OK
     *
     */
    public String hmset(String key, Map<String, String> map) {

        String s = jedisCluster.hmset(key, map);

        return s;
    }

    /**
     * 添加对应关系，如果对应关系已存在，则覆盖
     *
     * @param Strin key
     * @param Map
     * <String,String> 对应关系
     * @ 状态，成功返回OK
     *
     */
    public String hmset(byte[] key, Map<byte[], byte[]> map) {

        String s = jedisCluster.hmset(key, map);
        return s;
    }

    //*******************************************Strings*******************************************//
    /**
     * 根据key获取记录
     *
     * @param String key
     * @ 值
     *
     */
    public Object get(Object key) {
        //ShardedJedis jedisCluster = getShardedJedis();

        byte[] value = jedisCluster.get(SerializationUtils.serialize(key));

        return SerializationUtils.deserialize(value);
    }


    /**
     * 添加有过期时间的记录
     *
     * @param String key
     * @param int seconds 过期时间，以秒为单位
     * @param String value
     * @ String 操作状态
     *
     */
    public String setEx(byte[] key, int seconds, byte[] value) {

        String str = jedisCluster.setex(key, seconds, value);

        return str;
    }


	public String set(String key, Object value) {
		// TODO Auto-generated method stub
		return jedisCluster.set(SerializationUtils.serialize(key), SerializationUtils.serialize(value));
	}

}
