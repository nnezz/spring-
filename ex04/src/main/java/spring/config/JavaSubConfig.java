package spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;

@Configuration
public class JavaSubConfig {
	@Autowired
	private MemberDao memberDao;// 설정파일을 하나로 합치는 경우 주입 대상으로 autowired 로 전달 받는다.
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}

	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemDao(memberDao);
		return infoPrinter;
	}
}
