package com.yash.cemapp.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yash.cemapp.model.Event;
import com.yash.cemapp.service.EventService;
import com.yash.cemapp.utill.DateUtill;

@Controller
public class EventController {

	@Autowired
	private EventService eventService;
	private static int id = 1;

	@RequestMapping(value = "/addEvent.ds")
	public String addEvent() {
	//	eventService.deleteAllEvents();

		return "eventform";
	}

	@RequestMapping(value = "/addEventForm.ds", method = RequestMethod.POST)
	public String addTraining(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "eventform";
		} else {
			event.setId(id++);
			eventService.addEvent(event);
			return "redirect:/eventDashboard.ds";
		}
	}
	
	@RequestMapping(value = "/eventDashboard.ds", method = RequestMethod.GET)
	public String showDashboard(Model model) {
		model.addAttribute("listById", eventService.listEvent());
		return "dashboard";
	}

	@RequestMapping("/Delete.ds")
	public String delete(@RequestParam("eventId") String eventId) {
		eventService.delete(Integer.parseInt(eventId));
		return "redirect:/eventDashboard.ds";
	}

	@RequestMapping(value = "/updateEventform.ds", method = RequestMethod.GET)
	public String updateEventform(@RequestParam("eventId") String eventId, Model model) {
		model.addAttribute("event", eventService.listEvent(Integer.parseInt(eventId)));
		return "eventUpdate";
	}

	@RequestMapping(value = "/updatedEvent.ds")
	public String update(@Valid @ModelAttribute("event") Event event) {
		eventService.update(event);
		return "redirect:/eventDashboard.ds";
	}
	
	@RequestMapping(value="/deleteSelected.ds",method=RequestMethod.GET)
	public String deleteSelected(@RequestParam("eventId") String[] eventIds) {
		for (int i = 0; i < eventIds.length; i++) {
			eventService.delete(Integer.parseInt(eventIds[i]));
		}
		return "redirect:/eventDashboard.ds";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields(new String[] { "duration" });
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, "startDate", new CustomDateEditor(dateFormat, true));
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, "endDate", new CustomDateEditor(dateFormat1, true));
	}
}
