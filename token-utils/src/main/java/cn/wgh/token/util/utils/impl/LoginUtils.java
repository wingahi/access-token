package cn.wgh.token.util.utils.impl;

import cn.wgh.token.base.storage.api.DataStorageApi;
import cn.wgh.token.base.token.access.api.LoginApi;
import cn.wgh.token.base.token.access.emun.PlatformEmun;
import cn.wgh.token.util.message.impl.SimpleRemoveLoginMessage;

public class LoginUtils extends UserUtils implements LoginApi{
	
	public LoginUtils(DataStorageApi dataStorageApi) {
		super(dataStorageApi);
	}

	public String login(long userId, Object userInfo,PlatformEmun platformEmun) {
		String token = super.setToken(userId, platformEmun);
		super.setUserInfo(userId, userInfo);
		return token;
	}

	//@Override
	public boolean isLogin(String token) {
		return super.getUserIdByToken(token)!=0;
	}

}
