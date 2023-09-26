package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.MemberDao;
import spring.exception.IdPasswordNotMatchingException;
import spring.vo.AuthInfo;
import spring.vo.Member;
@Service
public class AuthService {
	@Autowired	
	private MemberDao memberDao;
	
	
	public AuthInfo authenticate(String email, String password) {
		Member member = memberDao.selectByEmail(email);
		
		if(member==null) {//회원이 없는경우
			throw new IdPasswordNotMatchingException();
		}
		
		if(!member.getPassword().equals(password)) { // 비밀번호가 일치하지 않는경우
			throw new IdPasswordNotMatchingException();
		}
		
		return new AuthInfo(member.getId(), member.getEmail(), member.getName());
	}
}
