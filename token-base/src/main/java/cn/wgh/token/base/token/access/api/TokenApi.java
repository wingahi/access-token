/**
 * 
 */
package cn.wgh.token.base.token.access.api;

import cn.wgh.token.base.token.access.emun.PlatformEmun;

/**
 * @author Administrator
 *
 */
public interface TokenApi {
	/**
	 * 获取token
	 * @param userId 用户id
	 * @param platformEmun 平台
	 * @return
	 */
	public String getToken(long userId,PlatformEmun platformEmun);
	/**
	 * 设置token
	 * @param userId 用户id
	 * @param platformEmun 平台
	 * @return
	 */
	public String setToken(long userId,PlatformEmun platformEmun);
	
	/**
	 * 获取userId
	 * @param token
	 * @return
	 */
	public long getUserIdByToken(String token);
}
