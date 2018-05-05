package cn.wgh.token.util.message.emun;

public enum MessageType {
	remove_login("剔除登陆")
	;
	
	
	private MessageType(String desciption) {
		this.desciption = desciption;
	}

	private String desciption;

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	
}
