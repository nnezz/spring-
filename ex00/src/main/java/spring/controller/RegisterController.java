package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.exception.AlreadyExistingMemberException;
import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;



@Controller
@RequestMapping("/register")  //컨트롤러 클래스 내부의 경로에서 공통된 부분을 따로 추출해서 작성 가능
public class RegisterController {
	@Autowired	
	private MemberRegisterService memberRegisterService;
	
	private String url = "register";
	// http://localhost:8085/ex00/경로 -> 서블릿 동작
	//web.xml @webservlet()
	//스프링에서는 서블릿 x ->dispatcherServlet이 동작
	//
	//http://localhost:8085/ex00/register/step1
	@RequestMapping("/step1")
	public String handlerStep1() {
		
		return url+"/step1";  // /WEB-INF/views/register/step1.jsp
	}
	
	//http://localhost:8085/ex00/register/step2
	//RequestMapping 은 get 과 post 를 구분하지 않음 -> method 방식 method = RequestMethod.POST ->post요청에만 반응
	
	
	/*@RequestMapping(value="register/step2",method = RequestMethod.POST)
	public String handlerStep2() {
		
		return "register/stpe2";
	}*/
	//파라미터 읽어오기
	//1.request 객체의 파라미터를 이용한 방식
	/* @RequestMapping(value="register/step2",method = RequestMethod.POST)
	public String handlerStep2(HttpServletRequest request) {
				//request 객체의 파라미터를 이용한 방식
		String agreeParam = request.getParameter("agree");
				//true ,false
		
		if(agreeParam == null || !agreeParam.equals("true")) {
			
			return "register/step1";
		}
		return "register/stpe2";
	} */
	//2. @RequestParam 어노테이션을 이용한 방식 
	@PostMapping("/step2")
	public String handlerStep2(@RequestParam(value="agree",required = false,defaultValue = "false") Boolean agree) {			
		
		if(!agree) {			
			return "register/step1";
		}
		return "register/step2";
	}
	
	
	// 기본 적인 페이지 이동방식
	// 요청 - > 컨트롤러 - > 뷰 - > 응답
	// ==========포워드======>
	
	// 리 다이렉트
	// 요청 - > 컨트롤러 - > 리다이렉트 -> 요청 -> 컨트롤러 -> 뷰 - >응답
	@GetMapping("/step2") //주소창에 직접 입력해서 이동 : http://localhost:8085/ex00/register/step2
	public String handlerStep2Get() { 
		
		//return "register/step1"; //어쨋든 주소창에는 나옴
		//return "redirect:register/step1";
		// 클라이언트에게 아래 주소로 이동지시
		// http://localhost:8085/ex00/register/step1
		
		
	return "redirect:http://localhost:8085/ex00/register/step1";
	}
	
	
	@GetMapping("/step3")
	public String handlerStep3Get() {
		return "redirect:./step1";
	}
	
	//redirect : /~~~~~~~   http://localhost:8085/ex00/~~~  root
	//redirect : ../~~~~~	http://localhost:8085/ex00/~~~  상위폴더
	//redirect : ~~~~~~~~	http://localhost:8085/ex00/register/~~~  현재위치
	//redirect : ./~~~~~~	http://localhost:8085/ex00/register/~~~  현재위치

	
	
	
	
	
	
	
	
	/*
	@PostMapping("/step3")
	public String handlerStep3(
			@RequestParam("email") String email,
			@RequestParam("name") String name,
			@RequestParam("password") String password,
			@RequestParam("confirmPassword") String confirmPassword) {
		
		
		// form 태그에서 데이터 가져오기
		// 1. HttpServletRequest request    .getParameter("name");
		// 2. @RequestParam("email") String email => 형변환도 필요하면 알아서 진행
		// 
		
		return "register/step3";
	} */
	
	@PostMapping("/step3")    //=> 커맨드 객체      외부에서 사용할 이름(request.setAttribute("formData",~~~)) 
	public String handlerStep3(@ModelAttribute("formData") RegisterRequest regReq) {
		// 여러 데이터를 한꺼번에 전달 받는 방식
		// 전제 조건 : 폼에서 사용한 이름과 객체의 필드명이 일치하는 경우
		//          =>폼에서 사용한 이름과 set 메서드의 필드명이 일치하는 경우
		
		try {
			// MemberRegisterrService 가 필요함
			// 1) private MemberRegisterrService memberRegisterrService ; 필드생 성
			// 2) @Autowired로 의존 주입 => 자동주입을 지원하기 위한 기능 	<context:annotation-config/>적용	
 
			memberRegisterService.regist(regReq); //회원 가입 기능 동작
			
			return "register/step3";
		}catch (AlreadyExistingMemberException e) {
			
			return "register/step2";
			}
				
		
		}

	
	
	
	
	
	
	
	
	
	
	
	
}
