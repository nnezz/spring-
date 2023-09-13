package spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.printer.MemberInfoPrinter;
import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx1.xml");
		MemberRegisterService regSvc = 
				ctx.getBean("memberRegSvc",MemberRegisterService.class);
		MemberInfoPrinter info = 
				ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("hong@naver.com");
		regReq.setName("홍길동");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		
		
		
		regSvc.regist(regReq);
		
		info.printMemberInfo("hong@naver.com");
	}

}
