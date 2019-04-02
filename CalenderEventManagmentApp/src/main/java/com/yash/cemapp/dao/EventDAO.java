package com.yash.cemapp.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.yash.cemapp.model.Event;

/**
 * This is DAO layer of Event
 * @author savinay.sinha
 *
 */
public interface EventDAO {
	
	/**
	 * This will save the event in repository
	 * @param event to be saved
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	void save(Event event);
	
	/**
	 * This will fetch all the list of event
	 * @return the list of all event
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	List<Event> list();
	
	/**
	 * this will delete an Event
	 * @param id to be deleted
	 */
	void delete(int id);
	
	/**
	 * This will empty the list
	 */
	void emptyList() ;

	/**
	 * This will update the event
	 * @param event that is updated
	 */
	void update(Event event);

	/**
	 * this will search in list using id
	 * @param id to be used to search the Event
	 * @return an Event if found
	 */
	Event searchById(int id);

}
