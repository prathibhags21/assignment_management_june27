package com.assign.app.service;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.assign.app.dao.ChangePasswordDAO;
import com.assign.app.dto.ChangePasswordDTO;
import com.assign.app.dto.UserDTO;
import com.assign.app.util.EncryptionDecryption;

@Service
public class ChangePasswordService {

	@Autowired
	private ChangePasswordDAO changePasswordDAO;

	@Autowired
	private MailSender mailSender;

	public ChangePasswordService() {
		System.out.println("changePasswordService stared");
	}

	public String changePasswordService(String newPassword, String email) throws UnsupportedEncodingException {

		System.out.println("invoked()");

		if (true) {
			System.out.println("entered new password is" + newPassword);

			String enPass = EncryptionDecryption.encrypt(newPassword);
			System.out.println("Encrypted password in db:" + enPass);

			changePasswordDAO.changePasswordDAO(enPass, email);
			String subject = "Change password mail from assignment management";

			String text = "your password is changed \n" + "please login by using \n" + "password:" + newPassword;

			SimpleMailMessage simpleMailMessege = new SimpleMailMessage();

			simpleMailMessege.setTo(email);
			simpleMailMessege.setSubject(subject);
			simpleMailMessege.setText(text);

			mailSender.send(simpleMailMessege);

			return "Mail sent to:\t " + email;

		}
		return "successfully from service";

	}

	/*
	 * if(newPassword!=null) {
	 * 
	 * @SuppressWarnings("unused") boolean vNewPass = data.isValidNewPass(vNewPass);
	 * System.out.println("valid data...going to save in db"); return true;
	 * 
	 * 
	 * } else { System.out.println("invalid password"); return false; }
	 * 
	 */

}
