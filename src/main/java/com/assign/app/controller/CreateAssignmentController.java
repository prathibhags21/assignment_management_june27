package com.assign.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assign.app.dto.CreateAssignmentDTO;
import com.assign.app.dto.UserDTO;
import com.assign.app.service.CreateAssignmentService;

@Controller
@RequestMapping("/")
public class CreateAssignmentController {

	@Autowired
	private CreateAssignmentService createAssignmentService;

	public CreateAssignmentController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/createAssignment.ams", method = RequestMethod.POST)
	public void createAssignment(CreateAssignmentDTO assignmentDTO, HttpServletRequest request) {

		System.out.println("Data from html : " + assignmentDTO);

		HttpSession session = request.getSession(false);
		if (session != null) {
			UserDTO dtoFrmDB = (UserDTO) session.getAttribute("dtoFrmDB");
			if (dtoFrmDB != null) {
				assignmentDTO.setEmaiId(dtoFrmDB.getEmail());
				createAssignmentService.createAssignment(assignmentDTO);
			}
		}

	}

}
