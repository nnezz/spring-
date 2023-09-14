package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import spring.aspect.ExeTimeAspect2;
import spring.calc.Calculator;
import spring.calc.ImpCalculator;
import spring.calc.RecCalculator;

@Configuration
@EnableAspectJAutoProxy 
public class JavaConfig {
	@Bean
	public Calculator impeCalc() {
		return new ImpCalculator();
	}
	

	
	@Bean
	public Calculator recCalc() {
		return new RecCalculator();
	}
	
	//프록시 객체 (공통 기능) 도 빈으로 등록
	
	@Bean
	public ExeTimeAspect2 exeTimeAspect() {
		return new ExeTimeAspect2();
	}
	
	
}
