package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.exception.IdPasswordNotMatchingException;
import spring.exception.MemberNotFoundException;
import spring.service.ChangePasswordService;

public class Main02 {
	
	public static void main(String[] args) {
		//스프링 컨테이너 생성
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc",ChangePasswordService.class);
		
		
		try {
		changePwdSvc.changePassword("lee@naver.com","4321","1234");
		System.out.println("비밀번호를 변경했습니다.");
		}catch (MemberNotFoundException e) {
			System.out.println("회원이 존재하지 않습니다.");
		}catch (IdPasswordNotMatchingException e) {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		ctx.close();
	}}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	