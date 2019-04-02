package com.yash.tmsapp.domain;
/**
 * this will be used to transfer the data from one layer to another layer
 * @author savinay.sinha
 *
 */
public class Training {
	/**
	 * id of training
	 */
	private int id;
	/**
	 * userId of training
	 */
	private int userId;
	/**
	 * title of training
	 */
	private String title;
	/**
	 * objective of training
	 */
	private String objective;
	
	/**
	 * course of training
	 */
	private String course;
	
	/**
	 * mode of training
	 */
	private int mode;
	
	/**
	 * batch size of training
	 */
	private int batchSize;
	
	/**
	 * expectation from training
	 */
	private String expectation;
	
	/**
	 * duration of training 
	 */
	private int duration;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public int getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	public String getExpectation() {
		return expectation;
	}
	public void setExpectation(String expectation) {
		this.expectation = expectation;
	}

	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Training [id=" + id + ", userId=" + userId + ", title=" + title + ", objective=" + objective
				+ ", course=" + course + ", mode=" + mode + ", batchSize=" + batchSize + ", expectation=" + expectation
				+ ", duration=" + duration + "]";
	}
	
	

}
