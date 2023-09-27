package spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.exception.IdPasswordNotMatchingException;
import spring.service.ChangePasswordService;
import spring.vo.AuthInfo;
import spring.vo.ChangePwdCommand;
import validator.ChangePwdCommandValidator;

@Controller
@RequestMapping("edit/changePassword")
public class ChangePwdController {
	@Autowired
	private ChangePasswordService changePasswordService;

	@GetMapping
	public String form(Model model) {
		model.addAttribute("ChangePwdCommand", new ChangePwdCommand());

		return "edit/changePwdForm";
	}

	@PostMapping
	public String submited(ChangePwdCommand changePwdCommand, Errors error, HttpSession session) {
		// 1. 검증
		new ChangePwdCommandValidator().validate(changePwdCommand, error);

		if (error.hasErrors()) {
			return "edit/changePwdForm";
		}

		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

		try {

			changePasswordService.changePassword(authInfo.getEmail(), changePwdCommand.getCurrentPassword(),
					changePwdCommand.getNewPassword());
			return "edit/changePwd";
		} catch (IdPasswordNotMatchingException e) {
			//
			error.rejectValue("currentPassword", "notMatching");
			return "edit/changePwdForm";
		}
	}

}
