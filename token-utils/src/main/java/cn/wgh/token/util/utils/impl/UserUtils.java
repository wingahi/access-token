/**
 * 
 */
package cn.wgh.token.util.utils.impl;

import cn.wgh.token.base.storage.api.DataStorageApi;
import cn.wgh.token.base.token.access.api.UserApi;
import cn.wgh.token.base.token.access.emun.PlatformEmun;

/**
 * @author Administrator
 *
 */
public class UserUtils extends TokenUtils implements UserApi {

	public UserUtils(DataStorageApi dataStorageApi) {
		super(dataStorageApi);
	}

	/* (non-Javadoc)
	 * @see token.base.wgh.token.access.api.UserApi#getUserInfo(java.lang.String)
	 */
	public Object getUserInfo(String token) {
		long userId = super.getUserIdByToken(token);
		return dataStorageApi.get(Long.valueOf(userId).toString());
	}

	public Object getUserInfo(long userId) {
		return dataStorageApi.get(Long.valueOf(userId).toString());
	}
	
	/* (non-Javadoc)
	 * @see token.base.wgh.token.access.api.UserApi#setUserInfo(java.lang.String, long, java.lang.Object)
	 */
	public void setUserInfo(long userId, Object userInfo) {
		dataStorageApi.save(Long.valueOf(userId).toString(), userInfo, Integer.MAX_VALUE);
	}

	public boolean isLogin(long userId,PlatformEmun platformEmun) {
		Object token = dataStorageApi.get(TOKEN_KEY_PRE+Long.valueOf(userId).toString(), platformEmun.name());
		Object oldUserId = dataStorageApi.get(TOKEN_KEY_PRE+token);
		return oldUserId==null?false:(Long.valueOf(oldUserId.toString()).longValue()==userId?true:false);
	}

}
