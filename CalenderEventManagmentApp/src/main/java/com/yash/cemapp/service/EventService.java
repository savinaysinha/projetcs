package com.yash.cemapp.service;

import java.util.List;

import com.yash.cemapp.model.Event;

/**
 * This is the Service layer for performing all the business logic
 * @author savinay.sinha
 *
 */
public interface EventService {
	
	/**
	 * This will save an event 
	 * @param event to be saved
	 */
	void addEvent(Event event);

	/**
	 * this will list out all the saved event 
	 * @return
	 */
	List<Event> listEvent();

	/**
	 * this will delete an Event
	 * @param id to be deleted
	 */
	void delete(int id);

	/**
	 * delete all events
	 */
	void deleteAllEvents();

	/**
	 * This will update the event
	 * @param event that is updated
	 */
	void update(Event event);


	/**
	 * This will fetch an Event 
	 * @param id to be used to fetch Event
	 * @return Event if found
	 */
	Event listEvent(int id);

}
