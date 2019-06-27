package com.assign.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.assign.app.dto.UserDTO;
import com.assign.app.service.AssignService;

@Controller
@RequestMapping("/")
public class AssignController {

	@Autowired
	private AssignService assignService;

	public AssignController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/assignees.ams", method = RequestMethod.POST)
	public ModelAndView assignController(@RequestParam Integer pin, @RequestParam String email,
			HttpServletRequest request, Model model) {
		System.out.println("pin " + pin + " email " + email);
		HttpSession session = request.getSession(false);
		if (session != null) {
			UserDTO dtoFrmDB = (UserDTO) session.getAttribute("dtoFrmDB");
			if (dtoFrmDB != null) {
				assignService.assign(pin, email, dtoFrmDB.getEmail());
			}
		}

		return new ModelAndView("assign", "msg", "successfully send mail");
	}

}
