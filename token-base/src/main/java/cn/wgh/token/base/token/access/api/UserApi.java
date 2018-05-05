/**
 * 
 */
package cn.wgh.token.base.token.access.api;

import cn.wgh.token.base.token.access.emun.PlatformEmun;

/**
 * @author Administrator
 *
 */
public interface UserApi extends TokenApi {
	/**
	 * 获取用信息
	 * @param token
	 * @return
	 */
	public Object getUserInfo(String token);
	/**
	 * 获取用信息
	 * @param userId
	 * @return
	 */
	public Object getUserInfo(long userId);
	/**
	 * 设置用户信息
	 * @param userId
	 * @param userInfo
	 */
	public void setUserInfo(long userId,Object userInfo);
	/**
	 * 判断是否已登录
	 * @param userId
	 * @param platformEmun
	 * @return
	 */
	public boolean isLogin(long userId,PlatformEmun platformEmun);
	
}
