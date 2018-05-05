package cn.wgh.token.util.message.api;

import cn.wgh.token.util.message.model.Message;

public interface Messager {
	/**
	 * 通知
	 * @param message
	 */
	public void sendMessage(Message message);
}
