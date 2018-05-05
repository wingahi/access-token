package cn.wgh.token.util.message.impl;

import cn.wgh.token.util.message.api.Messager;
import cn.wgh.token.util.message.model.Message;

public class SimpleRemoveLoginMessage implements Messager {

	//@Override
	public void sendMessage(Message message) {
		System.out.println("剔除："+message.toString());
	}

}
