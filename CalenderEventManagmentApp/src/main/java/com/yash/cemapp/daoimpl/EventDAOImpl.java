package com.yash.cemapp.daoimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yash.cemapp.dao.EventDAO;
import com.yash.cemapp.model.Event;

/**
 * This class will perform implementation of EventDAO
 * 
 * @author savinay.sinha
 *
 */
@Repository
public class EventDAOImpl implements EventDAO {

	/**
	 * Repository of Event
	 */
	private List<Event> eventRepository;
	/**
	 * represents the files and directory pathnames
	 */
	private File file = null;

	/**
	 * This will be used to create a file and write data into it
	 */
	private FileOutputStream fos = null;

	/**
	 * This will be used for saving List of event into file
	 */
	private ObjectOutputStream oos = null;

	/**
	 * This will be used for reading data from the files
	 */
	private FileInputStream fileIn = null;

	/**
	 * It is used to recover those objects previously serialized
	 */
	private ObjectInputStream ois = null;
	private Event fetchedEvet;

	public EventDAOImpl() {
		eventRepository = new ArrayList<Event>();
	}

	public void save(Event event) {
		file = new File("userRepsoitory.txt");
		isFileExist();
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			idIncrement(event);
			eventRepository.add(event);
			oos.writeObject(eventRepository);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This will check for eventRepsitory if its size < 0 then set event id to 1
	 * otherwise fetched last Event id and increment new event with incremented
	 * fetched id
	 * 
	 * @param event
	 *            whose id to be incremented
	 */
	private void idIncrement(Event event) {
		if (eventRepository.size() != 0) {
			fetchedEvet = eventRepository.get(eventRepository.size() - 1);
			int id = fetchedEvet.getId();
			event.setId(++id);
		} else {
			event.setId(1);
		}
	}

	/**
	 * this will check if file exists then call list() and return list into
	 * eventRepository
	 */
	private void isFileExist() {
		if (file.exists()) {
			eventRepository = list();
		}
	}

	public List<Event> list() {
		try {
			readFile();
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return eventRepository;
	}

	public void delete(int id) {
		try {
			readFile();
			for (Event event : eventRepository) {
				if (event.getId() == id) {
					eventRepository.remove(event);
					break;
				}
			}
			writeFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this will close FileInputStream and FileOutputStream connection
	 * @throws IOException
	 */
	private void closeConnection() throws IOException {
		oos.close();
		ois.close();
	}

	public void emptyList() {
		try {
			readFile();
			eventRepository.clear();
			writeFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void update(Event event) {
		try {
			readFile();
			int index = 0;
			for (Event event1 : eventRepository) {
				if (event.getId() == event1.getId()) {
					eventRepository.remove(index);
					eventRepository.add(index, event);
					break;
				}
				index++;
			}
			writeFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this function will write new object into file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void writeFile() throws FileNotFoundException, IOException {
		file = new File("userRepsoitory.txt");
		fos = new FileOutputStream(file);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(eventRepository);
		closeConnection();
	}

	/**
	 * this will read object from file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file1 = new File("userRepsoitory.txt");
		fileIn = new FileInputStream(file1);
		ois = new ObjectInputStream(fileIn);
		eventRepository = (ArrayList<Event>) ois.readObject();
	}

	public Event searchById(int id) {
		List<Event> events = list();
		Event fetchedEvent = null;
		for (Event event : events) {
			if (event.getId() == id) {
				fetchedEvent = event;
			}
		}
		return fetchedEvent;
	}
}
