package com.yash.tmsapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.service.TrainingService;

@Controller
public class TrainingController {
	@Autowired
	private TrainingService trainingService;
	private static int id=1;
	
	@RequestMapping(value="/toAddTraining.ds")
	public String toAddTraining() {
		return "AddTraining";
	}
	
	@RequestMapping(value="/AddTraining.ds" , method = RequestMethod.POST)
	public String addTraining(@ModelAttribute("training") Training training,HttpSession session,Model model) {
		training.setId(id++);
		int userId = (Integer) session.getAttribute("loggedInUserId");
		training.setUserId(userId);
		trainingService.register(training);
		model.addAttribute("msg", "Succesfully Registered");
		return "redirect:/UserDashboard.ds";
	}
	
	@RequestMapping(value="/UserDashboard.ds",method=RequestMethod.GET)
	public String showDashboard(/*@RequestParam("msg") String msg,*/HttpSession session, Model model) {
		/*model.addAttribute("msg",msg);*/
		int loggedInUserId =  (Integer) session.getAttribute("loggedInUserId");
		model.addAttribute("listByUserId", trainingService.listByUserId(loggedInUserId));
		return "user-dashboard";
	}
	@RequestMapping(value="/DeleteSelected.ds",method=RequestMethod.GET)
	public String deleteSelected(@RequestParam("trainingId") String[] trainingIds) {
		for (int i = 0; i < trainingIds.length; i++) {
			trainingService.delete(Integer.parseInt(trainingIds[i]));
		}
		
		return "redirect:/UserDashboard.ds";
	}
	
	@RequestMapping("/Delete.ds")
	public String delete(@RequestParam("trainingId") String trainingId) {
		trainingService.delete(Integer.parseInt(trainingId));
		return "redirect:/UserDashboard.ds";
	}
	

	@RequestMapping(value="/UpdateTraining.ds",method=RequestMethod.POST)
	public String update(@ModelAttribute("training") Training training,HttpSession session) {
		int userId = (Integer) session.getAttribute("loggedInUserId");
		training.setUserId(userId);
		trainingService.update(training);
		return "redirect:/UserDashboard.ds";
	}
	
	@RequestMapping(value="/UpdateTrainingPage.ds")
	public String toUpdatePage(@RequestParam("trainingId") int trainingId,Model model) {
		
		Training training = trainingService.listByid(trainingId);
		model.addAttribute("training", training);
		return  "UpdateTraining";
	}
	@RequestMapping(value="/SearchText.ds",method=RequestMethod.POST)
	public String searchText(@RequestParam("search") String search,HttpSession session,Model model) {
		int loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
		List<Training> trainings = trainingService.searchText(loggedInUserId, search);
		model.addAttribute("listByUserId", trainings);
		return "user-dashboard";
	}
}
