package com.assign.app.controller;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assign.app.dto.ChangePasswordDTO;
import com.assign.app.service.ChangePasswordService;

@Controller
@RequestMapping("/")
public class ChangePasswordController {

	private final static Logger log = LoggerFactory.getLogger(ChangePasswordController.class);

	@Autowired
	private ChangePasswordService changePasswordService;

	public ChangePasswordController() {
		log.info(" change password controller started");

	}

	@RequestMapping(value = "/changepassword.ams", method = RequestMethod.POST)
	public ModelAndView changePasswordController(ChangePasswordDTO changePasswordDTO, Model model)
			throws UnsupportedEncodingException {
		log.info("invoked changePasswordController()...");

		model.addAttribute("email", changePasswordDTO.getEmail());

		changePasswordService.changePasswordService(changePasswordDTO.getNewPassword(), changePasswordDTO.getEmail());
		model.addAttribute("msg", "password changed sucessfully");
		return new ModelAndView("home", "msg", "change password successfully");
	}

}
