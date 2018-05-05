package cn.wgh.token.access.impl.test.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private Long id;
	private String name;
	private Date date;
	private Boolean bool;
	
	public User() {
		super();
	}
	
	public User(Long id, String name, Date date, Boolean bool) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.bool = bool;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Boolean getBool() {
		return bool;
	}
	public void setBool(Boolean bool) {
		this.bool = bool;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", date=" + date + ", bool=" + bool + "]";
	}
	
}
