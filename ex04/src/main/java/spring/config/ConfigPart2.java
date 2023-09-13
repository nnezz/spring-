package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;

@Configuration
public class ConfigPart2 {
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}

	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		return infoPrinter;
	}
}
