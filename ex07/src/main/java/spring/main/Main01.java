package spring.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberListPrinter;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;

public class Main01 {
	
	public static void main(String[] args) {
		//스프링 컨테이너 생성
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		
		//회원 등록 기능
		System.out.println("-------회 원 등 록--------");
		MemberRegisterService regSvc = ctx.getBean("regSvc",MemberRegisterService.class);
		registerTest(regSvc);
		
			
		
			
		// 회원 전체 정보 출력
		System.out.println("-------전체 회원 정보출력--------");
		MemberListPrinter listPrt =  ctx.getBean("listPrinter",MemberListPrinter.class);
		listPrt.printAll();
		
		
		
		
		//단일 회원 정보 출력
		System.out.println("-------단일 회원 정보출력--------");
		MemberInfoPrinter infoPrt =  ctx.getBean("infoPrinter",MemberInfoPrinter.class);
		infoPrt.printMemberInfo("hwang@naver.com");
		
		//총 회원수 출력
		System.out.println("-------총 회원수 출력--------");
		MemberDao dao = ctx.getBean("dao",MemberDao.class);
		System.out.println("전체 회원 수 : "+dao.count());

		//비밀번호 변경기능
		System.out.println("-------비밀번호 변경--------");
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc",ChangePasswordService.class);
		changePwdTest(changePwdSvc,dao);	
		
	}

	private static void changePwdTest(ChangePasswordService changePwdSvc, MemberDao dao) {
		// 
		String email = "hwang@naver.com";
		
		String oldPwd = dao.selectByEmail(email).getPassword();
		String newPwd = "";
		
		if(oldPwd.equals("1234")) {
			newPwd = "4321";
		} else if (oldPwd.equals("4321")) {
			newPwd= "1234";
		}
		
		changePwdSvc.changePassword(email, oldPwd, newPwd);
	}

	private static void registerTest(MemberRegisterService regSvc) {
		RegisterRequest rr = new RegisterRequest();
		
		//날짜를 문자열로 만들어주기 위한 포멧팅 객체 -- 현재 날짜를 이용한 임의의 이름을 생성
		SimpleDateFormat dataFormat = new SimpleDateFormat("YYYYMMdd-HHmmss");
		String str = dataFormat.format(new Date());
		
		rr.setEmail(str+"@naver.com");
		rr.setName(str);
		rr.setPassword("1234");
		rr.setConfirmPassword("1234");
		
		regSvc.regist(rr); //회원 가입 기능
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
