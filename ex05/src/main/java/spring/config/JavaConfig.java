package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.bean.Client;
import spring.bean.Client2;

@Configuration
public class JavaConfig {
	
	@Bean(initMethod = "connect", destroyMethod = "close")
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("자바서버");
		return client2;
	}
		@Bean
		public Client client() {
			Client client = new Client();
			client.setHost("자바서버1");
			return client;
			}
		@Bean
		@Scope("prototype") // 범위가 프로토 타입으로 지정
		public Client client3() {
			Client client = new Client();
			client.setHost("자바서버3");
			return client;
			}
}
