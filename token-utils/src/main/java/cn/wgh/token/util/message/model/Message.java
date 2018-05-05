package cn.wgh.token.util.message.model;

import cn.wgh.token.util.message.emun.MessageType;

public class Message {
	private long timestamp;
	private MessageType type;
	private Object data;
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Message [timestamp=" + timestamp + ", type=" + type + ", data=" + data + "]";
	}
	
}
