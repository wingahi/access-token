/**
 * 
 */
package cn.wgh.token.util.utils.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.wgh.token.base.storage.api.DataStorageApi;
import cn.wgh.token.base.token.access.abstractUtils.AbstractTokenUtils;
import cn.wgh.token.base.token.access.api.TokenApi;
import cn.wgh.token.base.token.access.emun.PlatformEmun;
import cn.wgh.token.util.api.TokenBuilderApi;
import cn.wgh.token.util.impl.DefaultTokenBuilder;
import cn.wgh.token.util.message.api.Messager;
import cn.wgh.token.util.message.emun.MessageType;
import cn.wgh.token.util.message.impl.SimpleRemoveLoginMessage;
import cn.wgh.token.util.message.model.Message;

/**
 * @author Administrator
 *
 */
public class TokenUtils extends AbstractTokenUtils implements TokenApi {

	protected int expireSeconds = -1;
	
	private TokenBuilderApi tokenBuilderApi;
	
	private Messager messager;
	
	public void setRemoveLoginMessage(Messager messager) {
		this.messager = messager;
	}
	
	private static final TokenBuilderApi DEFAULT_TOKEN_BUILDER =new  DefaultTokenBuilder();
	
	public void setExpireSeconds(int expireSeconds) {
		this.expireSeconds = expireSeconds;
	}
	
	@Autowired
	protected DataStorageApi dataStorageApi;

	public TokenUtils(DataStorageApi dataStorageApi) {
		super();
		this.dataStorageApi = dataStorageApi;
	}

	
	
	public TokenBuilderApi getTokenBuilderApi() {
		if(tokenBuilderApi==null){
			tokenBuilderApi = DEFAULT_TOKEN_BUILDER;
		}
		return tokenBuilderApi;
	}



	public void setTokenBuilderApi(TokenBuilderApi tokenBuilderApi) {
		this.tokenBuilderApi = tokenBuilderApi;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see token.base.wgh.token.access.api.TokenApi#getToken(long,
	 * token.base.wgh.token.access.emun.PlatformEmun)
	 */
	public String getToken(long userId, PlatformEmun platformEmun) {
		return (String) dataStorageApi.get(TOKEN_KEY_PRE+Long.valueOf(userId).toString(), platformEmun.name());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see token.base.wgh.token.access.api.TokenApi#setToken(long,
	 * token.base.wgh.token.access.emun.PlatformEmun)
	 */
	public String setToken(long userId, PlatformEmun platformEmun) {
		String oldToken = getToken(userId, platformEmun);
		if(oldToken!=null && !oldToken.isEmpty()){
			//立即过期旧token
			dataStorageApi.setExpireTime(TOKEN_KEY_PRE+oldToken, -1);
			//剔除登录，添加消息通知
			if(messager!=null){
				Map<String,Object> dataMap = new HashMap();
				dataMap.put("userId", userId);
				dataMap.put("oldToken", oldToken);
				Message message = new Message();
				message.setTimestamp(Calendar.getInstance().getTimeInMillis());
				message.setType(MessageType.remove_login);
				message.setData(dataMap);
				messager.sendMessage(message);
			}
		}
		String token = getTokenBuilderApi().doGen(null);
		dataStorageApi.save(TOKEN_KEY_PRE+token,Long.valueOf(userId).toString(), expireSeconds);
		dataStorageApi.save(TOKEN_KEY_PRE+Long.valueOf(userId).toString(),platformEmun.name(),  token,Integer.MAX_VALUE);
		return token;
	}

	public long getUserIdByToken(String token) {
		Object userId = dataStorageApi.get(TOKEN_KEY_PRE+token);
		return userId==null?0l:Long.valueOf(userId.toString()).longValue();
	}

	public void lengthenExpireTime(String token) {
		// TODO Auto-generated method stub
		dataStorageApi.setExpireTime(TOKEN_KEY_PRE+token, expireSeconds);
	}
}
