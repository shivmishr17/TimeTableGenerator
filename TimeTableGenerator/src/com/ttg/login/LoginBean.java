package com.ttg.login;

import java.io.Serializable;

public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String pwd;

	public LoginBean(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
