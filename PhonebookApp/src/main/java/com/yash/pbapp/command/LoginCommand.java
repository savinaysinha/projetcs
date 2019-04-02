package com.yash.pbapp.command;

/**
 * This is the command class which is used when login process has to done
 * using this command date will flow from layer tp layer
 * @author savinay.sinha
 *
 */
public class LoginCommand {
	
	private String loginname;
	private String password;
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
