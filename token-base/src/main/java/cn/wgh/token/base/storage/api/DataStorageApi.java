/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wgh.token.base.storage.api;

/**
 *
 * @author Administrator
 */
public interface DataStorageApi {
	/**
	 * 保存数据
	 * @param key
	 * @param data
	 */
	public void save(String key,Object data);
	/**
	 * 保存数据
	 * @param key
	 * @param data
	 * @param seconds
	 */
	public void save(String key,Object data,int seconds);
	/**
	 * 保存数据
	 * @param key
	 * @param data
	 * @param seconds
	 */
	public void save(String key,String subKey,String data,long timestamp);
	/**
	 * 保存数据
	 * @param key
	 * @param data
	 * @param seconds
	 */
	public void save(String key,String subKey,String data,int seconds);
  /**
   * 设置过期时间
   * @param key
   * @param seconds
   */
	public void setExpireTime(String key,int seconds);
	 /**
	   * 设置过期时间
	   * @param key
	   * @param seconds
	   */
	public void setExpireTime(String key,long timestamp);
	/**
	 * 获取数据
	 * @param key
	 * @return
	 */
	public Object get(String key);
	/**
	 * 获取数据
	 * @param key
	 * @param subKey
	 * @return
	 */
	public Object get(String key,String subKey);
}
