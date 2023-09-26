package spring.vo;

import lombok.Data;

@Data
public class LoginCommand {
	//커맨드객체 : 클라이언트에서 서버로 보낼 때 데이터를 묶기 위한 클래스
	
	private String email;
	private String password;
	private boolean rememberEmail ;
	

}
