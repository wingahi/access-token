/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wgh.token.redis.protocol.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public interface RedisUtilsApi {
   


    /**
     * 设置key的过期时间，以秒为单位
     *
     * @param String key
     * @param 时间 ,已秒为单位
     * @ 影响的记录数
     *
     */
    public long expired(String key, int seconds);

    /**
     * 设置key的过期时间,它是距历元（即格林威治标准时间 1970 年 1 月 1 日的 00:00:00，格里高利历）的偏移量。
     *
     * @param String key
     * @param 时间 ,已秒为单位
     * @ 影响的记录数
     *
     */
    public long expireAt(String key, long timestamp);

   

    /**
     * 取消对key过期时间的设置
     *
     * @param key
     * @ 影响的记录数
     *
     */
    public long persist(String key) ;

    /**
     * 删除keys对应的记录,可以是多个key
     *
     * @param String ... keys
     * @ 删除的记录数
     *
     */
    public long del(String... keys) ;

    /**
     * 根据key获取记录
     *
     * @param String key
     * @ 值
     *
     */
    public Object get(Object key) ;

    /**
     * 添加记录,如果记录已存在将覆盖原有的value
     *
     * @param String key
     * @param String value
     * @ 状态码
     *
     */
    public String set(String key, Object value) ;

    /**
     * 判断key是否存在
     *
     * @param String key
     * @ boolean
     *
     */
    public boolean exists(String key) ;

   


    //*******************************************Hash*******************************************//
    /**
     * 从hash中删除指定的存储
     *
     * @param String key
     * @param String fieid 存储的名字
     * @ 状态码，1成功，0失败
     *
     */
    public long hdel(String key, String fieid) ;

    public long hdel(String key) ;

    /**
     * 测试hash中指定的存储是否存在
     *
     * @param String key
     * @param String fieid 存储的名字
     * @ 1存在，0不存在
     *
     */
    public boolean hexists(String key, String fieid) ;
    /**
     * 返回hash中指定存储位置的值
     *
     * @param String key
     * @param String fieid 存储的名字
     * @ 存储对应的值
     *
     */
    public String hget(String key, String fieid) ;
    /**
     * 以Map的形式返回hash中的存储和值
     *
     * @param String key
     * @ Map<Strinig,String>
     *
     */
    public Map<String, String> hgetAll(String key);
    /**
     * 添加一个对应关系
     *
     * @param String key
     * @param String fieid
     * @param Object value
     * @ 状态码 1成功，0失败，fieid已存在将更新，也返回0 *
     */
    public long hset(String key, String fieid, Object value) ;

    /**
     * 添加对应关系，只有在fieid不存在时才执行
     *
     * @param String key
     * @param String fieid
     * @param String value
     * @ 状态码 1成功，0失败fieid已存 *
     */
    public long hsetnx(String key, String fieid, String value) ;
    

    /**
     * 获取hash中value的集合
     *
     * @param String key
     * @ List<String>
     *
     */
    public List<String> hvals(String key) ;

    /**
     * 返回指定hash中的所有存储名字,类似Map中的keySet方法
     *
     * @param String key
     * @ Set<String> 存储名称的集合
     *
     */
    public Set<String> hkeys(String key);

    /**
     * 获取hash中存储的个数，类似Map中size方法
     *
     * @param String key
     * @ long 存储的个数
     *
     */
    public long hlen(String key) ;

    /**
     * 根据多个key，获取对应的value，返回List,如果指定的key不存在,List对应位置为null
     *
     * @param String key
     * @param String ... fieids 存储位置
     * @ List<String>
     *
     */
    public List<String> hmget(String key, String... fieids) ;

    /**
     * 添加对应关系，如果对应关系已存在，则覆盖
     *
     * @param Strin key
     * @param Map
     * <String,String> 对应关系
     * @ 状态，成功返回OK
     *
     */
    public String hmset(String key, Map<String, String> map) ;

}
