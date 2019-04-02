package com.yash.cemapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.cemapp.dao.EventDAO;
import com.yash.cemapp.model.Event;
import com.yash.cemapp.service.EventService;
import com.yash.cemapp.utill.DateUtill;
/**
 * This is the implementation class of EventService
 * @author savinay.sinha
 *
 */
@Service
public class EventServiceImpl implements EventService {

	/**
	 * This is the reference of EventDAO to call its method
	 */
	@Autowired
	private EventDAO eventDAO;
	public void addEvent(Event event) {
		int duration = (int) DateUtill.convertDatesToDays(event.getStartDate(),event.getEndDate());
		event.setDuration(duration);
		eventDAO.save(event);
		
	}
	public List<Event> listEvent() {
		return eventDAO.list();
	}
	public void delete(int id) {
		eventDAO.delete(id);
		
	}
	public void deleteAllEvents() {
		eventDAO.emptyList();
		
	}
	public void update(Event event) {
		int duration = (int) DateUtill.convertDatesToDays(event.getStartDate(),event.getEndDate());
		event.setDuration(duration);
		eventDAO.update(event);
		
	}
	public Event listEvent(int id) {
		return eventDAO.searchById(id);
	}
	
	

}
