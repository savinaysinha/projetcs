package com.yash.pbapp.model;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.internal.NotNull;

/**
 * This is POJO for the user
 * @author savinay.sinha
 *
 */
public class User {

	/**
	 * id of the user
	 */
	private Integer id;
	
	/**
	 * Name of user
	 */
	@Size(min=3,max=40)
	private String name;
	
	/**
	 * Phone number of user
	 */
	@Pattern(regexp="((\\+*)((0[ -]+)*|(91 )*)(\\d{12}+|\\d{10}+))|\\d{5}([- ]*)\\d{6}")
	private String phone;
	
	/**
	 * Address of User
	 */
	@NotEmpty
	private String address;
	
	/**
	 * email of User
	 */
	@Email @NotEmpty
	private String email;
	
	/**
	 * Status of user
	 * 1:Active 2:Blocked
	 */
	private Integer status;
	
	/**
	 * Role of User
	 * 1:Admin 2:User
	 */
	private Integer role;
	
	/**
	 * Login Name of User
	 */
	@Size(min=3,max=40)
	private String loginname;
	
	/**
	 * Password of User
	 */
	@Size(min=3,max=40)
	private String password;
	
	/**
	 * Created Date of user
	 */
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date created_At;
	
	/**
	 * Updated Date of User
	 */
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date updated_At;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

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

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + ", email=" + email
				+ ", status=" + status + ", role=" + role + ", loginname=" + loginname + ", password=" + password
				+ ", created_At=" + created_At + ", updated_At=" + updated_At + "]";
	}
	
	
}
