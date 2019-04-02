package com.yash.tmsapp.domain;

/**
 * this will be used to transfer the data from one layer to another layer
 * 
 * @author savinay.sinha
 *
 */
public class User {
	/**
	 * id of user PK
	 */
	private int id;
	/**
	 * name of the user
	 */
	private String name;
	/**
	 * phone number of user
	 */
	private String phone;
	/**
	 * work email of user
	 */
	private String email;
	/**
	 * login name of user
	 */
	private String loginName;
	/**
	 * password of the user
	 */
	private String password;
	/**
	 * role of the user 1:L&D, 2:business
	 */
	private int role;
	/**
	 * status of user 1:active, 2:blocked
	 */
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", loginName="
				+ loginName + ", password=" + password + ", role=" + role + ", status=" + status + "]";
	}

}
