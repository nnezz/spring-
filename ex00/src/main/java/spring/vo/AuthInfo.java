package spring.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthInfo {
	//로그인 성공 후 세션에 로그인 정보를 저장할 목적
	
	private long id;
	private String email;
	private String name;
}
