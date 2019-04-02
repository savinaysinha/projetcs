package com.yash.cemapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * This Event class is used to transfer data from one layer to another layer
 * 
 * @author savinay.sinha
 *
 */
public class Event implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id of Event
	 */
	private int id;

	/**
	 * Name of event or training
	 */
	@NotNull(message = "Name cannot be null")
	@Size(min = 5, max = 25, message = "Name should not be more than {max} and less than {min}")
	private String name;

	/**
	 * Start date of event
	 */
	private Date startDate;

	/**
	 * End date of event
	 */
	@Future
	private Date endDate;

	/**
	 * Total days to complete
	 */
	private int duration;

	/**
	 * Mode of Event like Online, Classroom, Webinar etc
	 */
	@NotNull(message = "Event Type cannot be null")
	@Size(min = 5, max = 25, message = "Event Type should not be more than {min} and less than {max}")
	private String eventType;

	/**
	 * Eligibility criteria to attend event like Fresher, lateral-3 to 4 year exp.,
	 * tech leads
	 */
	private String eligibility;

	/**
	 * Location of Event
	 */
	@NotNull(message = "Location cannot be null")
	@Size(min = 5, max = 25, message = "location should not be more than {min} and less than {max}")
	private String location;

	/**
	 * Capacity of event like no of candidates can join the event
	 */
	@Min(value = 1, message = "minimum 1")
	private int capacity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEligibility() {
		return eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", duration=" + duration + ", eventType=" + eventType + ", eligibility=" + eligibility + ", location="
				+ location + ", capacity=" + capacity + "]";
	}
}
