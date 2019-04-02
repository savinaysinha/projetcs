package com.yash.cemapp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import com.yash.cemapp.dao.EventDAO;
import com.yash.cemapp.daoimpl.EventDAOImpl;
import com.yash.cemapp.model.Event;

public class TestEventDAO_SaveAndList {

	public static void main(String[] args) throws ParseException {
		Event event = new Event();
		event.setName("pravin");
		event.setStartDate(new Date());
		event.setEndDate(new Date());
		event.setDuration(5);
		event.setEligibility("fresher");
		event.setEventType("Online");
		event.setCapacity(10);
		event.setLocation("Crystal IT Park,Indore");
		EventDAO eventDAO = new EventDAOImpl();
		// eventDAO.save(event);

		// eventDAO.emptyList();

		event.setId(4);
		// eventDAO.update(event);
		
		
	
	  /*  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	    String strDate = dateFormat.format(event.getEndDate());

	    event.setEndDate(dateFormat.parse(strDate));
	    
	    
	    System.out.println(event);*/
	    
	    
	    
	    
		Date myDate = new Date();
	    SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
	    String strDate = sm.format(myDate);
	    System.out.println(strDate);
	    
	    
	    
	    
	    
		
		
		
	
/*
		List<Event> events = eventDAO.list();
		for (Event event2 : events) {
			
			

			System.out.println(event2);
		}*/
	}

}
