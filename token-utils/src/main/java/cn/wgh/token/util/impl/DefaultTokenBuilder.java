/**
 * 
 */
package cn.wgh.token.util.impl;

import java.util.Calendar;

import cn.wgh.token.util.api.TokenBuilderApi;

/**
 * @author Administrator
 *
 */
public class DefaultTokenBuilder implements TokenBuilderApi {

	public String doGen(Object obj) {
		return String.valueOf(Calendar.getInstance().getTimeInMillis());
	}
	
}
