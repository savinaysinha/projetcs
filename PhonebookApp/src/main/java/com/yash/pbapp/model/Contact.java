package com.yash.pbapp.model;

import java.util.Date;

/**
 * This is the POJO of Appointment
 * @author savinay.sinha
 *
 */
public class Contact {
	/**
	 * id of the Contact
	 */
	private Integer id;
	
	/**
	 * id of the User
	 */
	private Integer userId;
	
	/**
	 * Name of Contact
	 */
	private String name;
	
	/**
	 * Phone number of Contact
	 */
	private String phone;
	
	/**
	 * group of contact
	 */
	private String cgroup;
	
	/**
	 * Address of Contact
	 */
	private String address;
	
	/**
	 * email of Contact
	 */
	private String email;
	
	/**
	 * Remark for the Contact
	 */
	private String remark;

	/**
	 * Created Date of Contact
	 */
	private Date created_At;
	
	/**
	 * CreatedBy
	 */
	private Integer created_By;
	
	/**
	 * Updated Date of Contact
	 */
	private Date updated_At;
	
	/**
	 * Updated By
	 */
	private Integer updated_By;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getCgroup() {
		return cgroup;
	}

	public void setCgroup(String cgroup) {
		this.cgroup = cgroup;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Integer getCreated_By() {
		return created_By;
	}

	public void setCreated_By(Integer created_By) {
		this.created_By = created_By;
	}

	public Integer getUpdated_By() {
		return updated_By;
	}

	public void setUpdated_By(Integer updated_By) {
		this.updated_By = updated_By;
	}

	

}
