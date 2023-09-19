package spring.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import spring.dao.MemberDao;
import spring.exception.AlreadyExistingMemberException;
import spring.vo.Member;
import spring.vo.RegisterRequest;

public class MemberRegisterService {	//회원 가입 기능
	
	private MemberDao dao;// = new MemberDao();
	
	@Autowired
	public MemberRegisterService(MemberDao dao) {	
	this.dao = dao;
}


	public void regist(RegisterRequest req) {
		Member member = dao.selectByEmail(req.getEmail());
		
		if(member != null) {
			throw new AlreadyExistingMemberException("이메일중복");
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		
		dao.insert(newMember);
	}
}
