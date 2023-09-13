package spring.bean;

public class Client2  { //빈으로 테스트
	
	private String host;
	
	public void setHost(String host) { // 문자열 객체를 주입하기 위한 메서드
		this.host = host;
		System.out.println("Client2.setHost() 실행 : 문자열 주입 진행");
	}



	public void send() {  // 실제 빈 객체가 사용할 메서드 
		System.out.println("Client2.send() to "+host);
												//의존적
	}
	
	//빈 초기화, 소멸시 사용할 메서드 임의로 작성
	public void connect() throws Exception{ //초기화시 사용할 메서드
		System.out.println("빈 초기화 : Client2.connect() 실행");
	}
	public void close() throws Exception{ //초기화시 사용할 메서드
		System.out.println("빈 초기화 : Client2.close() 실행");
	}


	
}
