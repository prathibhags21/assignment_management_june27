package com.assign.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.assign.app.dto.LoginDTO;
import com.assign.app.dto.UserDTO;
import com.assign.app.service.LoginService;
import com.assign.app.util.EncryptionDecryption;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private LoginService loginService;

	private final static Logger log = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/login.ams", method = RequestMethod.POST)
	public ModelAndView loginController(LoginDTO loginDTO, HttpServletRequest request) {
		log.info(loginDTO.toString());
		HttpSession session = request.getSession(true);
		UserDTO dtoFrmDB = loginService.loginService(loginDTO);
		log.info("dtoFrmDB->" + dtoFrmDB);

		if (dtoFrmDB != null) {

			if (loginDTO.getPassword().equals(EncryptionDecryption.decrypt(dtoFrmDB.getPassword()))) {
				log.info("login successfull");
				session.setAttribute("dtoFrmDB", dtoFrmDB);
				session.setMaxInactiveInterval(60*10);
				loginService.updateLastLoginAndFailCounterService(dtoFrmDB);
				return new ModelAndView("home", "msg", "login successfull").addObject("user", dtoFrmDB);
			} else {
				log.info("incorrect password");
				int failCount = dtoFrmDB.getFailCount();
				dtoFrmDB.setFailCount(failCount + 1);

				loginService.failedLoginService(dtoFrmDB);
				return new ModelAndView("login", "msg", "incorrect password");
			}
		}

		else {
			log.info("wrong email id");
			return new ModelAndView("login", "msg", "wrong password");
		}
	}

	public LoginController() {
		log.info("LoginController started");
	}

}
