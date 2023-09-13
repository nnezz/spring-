package spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean,DisposableBean { //빈으로 테스트
	
	private String host;
	
	public void setHost(String host) { // 문자열 객체를 주입하기 위한 메서드
		this.host = host;
		System.out.println("Client.setHost() 실행 : 문자열 주입 진행");
	}



	public void send() {  // 실제 빈 객체가 사용할 메서드 
		System.out.println("Client.send() to "+host);
												//의존적
	}



	@Override
	public void destroy() throws Exception {
		// 빈 소멸시 작동할 메서드
		System.out.println("빈 소멸:Client.destroy() 실행");
	}



	@Override
	public void afterPropertiesSet() throws Exception {
		// 빈 초기화시 작동할 메서ㅕ드
		System.out.println("빈 초기화:Client.afterPropertiesSet() 실행");
		
	}
}
