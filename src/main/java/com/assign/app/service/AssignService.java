package com.assign.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.assign.app.dao.AssignDAO;
import com.assign.app.dto.CreateAssignmentDTO;

@Service
public class AssignService {

	@Autowired
	private AssignDAO assignDAO;

	@Autowired
	private MailSender mailSender;

	public AssignService() {
		// TODO Auto-generated constructor stub
	}

	public void assign(Integer pin, String emailList, String emailFromDb) {

		CreateAssignmentDTO createAssignmentDTO = assignDAO.getCreateAssignmentFromDb(emailFromDb, pin);

		String[] emailListFromUi = emailList.split(",");
		String course = createAssignmentDTO.getCourse();
		String topic = createAssignmentDTO.getTopic();
		String description = createAssignmentDTO.getDescription();
		String deadLine = createAssignmentDTO.getDeadLine();
		String uploadType = createAssignmentDTO.getUploadType();
		

		for (int i = 0; i < emailListFromUi.length; i++) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(emailListFromUi[i]);
			mailMessage.setSubject("Assignment ");
			mailMessage.setText("course : " + course + " \n topic : " + topic + "\n description :" + description + "\n deadLine :"
					+deadLine+ "\n uploadType :" +uploadType);
			mailSender.send(mailMessage);

		}

		System.out.println("Dto from service : " + createAssignmentDTO);

	}

}
