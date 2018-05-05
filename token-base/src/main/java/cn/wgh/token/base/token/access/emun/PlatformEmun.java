package cn.wgh.token.base.token.access.emun;

public enum PlatformEmun {
	
	app("app"),
	web("web")
	;
	private String description;
	
	private PlatformEmun(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
