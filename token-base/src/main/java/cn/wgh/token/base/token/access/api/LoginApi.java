/**
 * 
 */
package cn.wgh.token.base.token.access.api;

import cn.wgh.token.base.token.access.emun.PlatformEmun;

/**
 * @author Administrator
 *
 */
public interface LoginApi extends UserApi,TokenApi{
	/**
	 * 
	 * @param userId
	 */
	public String login(long userId,Object userInfo,PlatformEmun platformEmun);
	/**
	 * 判断是否已登录
	 * @param token
	 * @return
	 */
	public boolean isLogin(String token);
}
