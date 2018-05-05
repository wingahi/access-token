/**
 * 
 */
package cn.wgh.token.util.impl;

import java.util.Random;

import cn.wgh.token.util.api.TokenBuilderApi;

/**
 * @author Administrator
 *
 */
public class TokenBuilder implements TokenBuilderApi {

	private static final Random RANDOM = new Random();
	
	public String doGen(Object obj) {
		// TODO Auto-generated method stub
		return String.valueOf(RANDOM.nextLong());
	}
	
}
