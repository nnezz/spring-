package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;
import spring.service.MemberRegisterService;
@Configuration
public class JavaConfig { // 스프링 빈 설정파일
	
	//<bean id="memberDao" class="spring.dao.MemberDao"/>
	//MemberDao MemberDao = new MemberDao();
	
	@Bean //빈으로 역할을 한다
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	
	//<bean id="memberRegSvc" class="spring.service.MemberRegisterService">
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao()); //생성자 주입
	}
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter alskdfj = new MemberInfoPrinter();
		/*
		 * alskdfj.setMemDao(memberDao()); //setter 메서드 주입
		 * alskdfj.setPrinter(printer());
		 */
		return alskdfj;
	}
	
	
}
