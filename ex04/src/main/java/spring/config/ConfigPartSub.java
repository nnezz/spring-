package spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;

@Configuration
public class ConfigPartSub {
	
	@Autowired
	private ConfigPartMain partmain; // ConfigPartMain 의  내용을 읽어온다.
	
	@Autowired
	private MemberDao memberDao;
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}

	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemDao(partmain.memberDao());
//		infoPrinter.setMemDao(memberDao);
		return infoPrinter;
	}
}
