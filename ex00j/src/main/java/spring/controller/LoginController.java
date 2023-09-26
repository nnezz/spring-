package spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.exception.IdPasswordNotMatchingException;
import spring.service.AuthService;
import spring.vo.AuthInfo;
import spring.vo.LoginCommand;
import validator.LoginCommandValidator;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private AuthService authService;
	
	@GetMapping
	public String form(Model model,
			@CookieValue(value = "rememberEmail",required = false)
			Cookie cookie){
		// rememberEmail이라는 쿠키를 읽어오고 없다면 그냥 옴
		// , HttpServletRequest request) {
		
		LoginCommand loginCommand  = new LoginCommand();
		
		//쿠키 읽어오기
		/*
		 * Cookie[] cookies = request.getCookies(); for(Cookie c: cookies) {
		 * if(c.getName().equals("rememberEmail")) {
		 * loginCommand.setEmail(c.getValue()); loginCommand.setRememberEmail(true); } }
		 */
		
		if(cookie != null) {
			loginCommand.setEmail(cookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		
		
		model.addAttribute("loginCommand",loginCommand);
		
		return "login/loginForm";
	}
	
	@PostMapping
	public String submit(LoginCommand loginCommand , Errors error,
			HttpSession session,HttpServletResponse response) {
		
		//1. 이메일 비밀번호가 입력되었는지 체크
		new LoginCommandValidator().validate(loginCommand, error);
		
		if(error.hasErrors()) {
			return "login/loginForm";
		}
		//2. 이메일,비밀번호 인증 처리
		try {
			AuthInfo authInfo =	authService.authenticate(
					loginCommand.getEmail(),
					loginCommand.getPassword());
			//로그인 성공시 처리할 코드 - 세션
			session.setAttribute("authInfo", authInfo);
			//로그인 성공시 처리할 저장용 쿠키생성
			Cookie rememberCookie = 
					new Cookie("rememberEmail",loginCommand.getEmail());
			
			//체크할 경우 저장 1년하기
			if(loginCommand.isRememberEmail()) {
				rememberCookie.setMaxAge(60*60*24*365);
			}else {
				rememberCookie.setMaxAge(0);
			}
			
			// 쿠키를 클라이언트에게 저장
			response.addCookie(rememberCookie);
			
			return "login/loginSuccess";
			
			
		} catch (IdPasswordNotMatchingException e) {
			// 이메일이 없거나 비밀번호가 틀린경우
			error.reject("IdPasswordNotMatching"); //전역 에러 코드
			return "login/loginForm";
		}
		
		
		
	}
	
}
