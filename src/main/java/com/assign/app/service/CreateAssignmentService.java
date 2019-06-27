package com.assign.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assign.app.dao.CreateAssignmentDAO;
import com.assign.app.dto.CreateAssignmentDTO;

@Service
public class CreateAssignmentService {

	@Autowired
	private CreateAssignmentDAO createAssignmentDAO;
	
	public void createAssignment(CreateAssignmentDTO assignmentDTO) {

		createAssignmentDAO.createAssignment(assignmentDTO);

	}

	
}
