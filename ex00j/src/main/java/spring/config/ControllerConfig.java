package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.controller.RegisterController;

@Configuration
@ComponentScan(basePackages = {"spring.controller","spring.service","spring.commonException"})
public class ControllerConfig {
	//필요한 번들을 등록
	//자동 주입이 알아서 지원
	//생성자를 통한 자동 주입 지원 X
	
	//수동으로 직접 빈을 지정할 필요가 있는 경우
	@Bean public RegisterController registerController() {
		return new RegisterController();
	}
	
}
