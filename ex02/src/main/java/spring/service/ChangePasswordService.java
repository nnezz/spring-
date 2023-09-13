package spring.service;

import spring.dao.MemberDao;
import spring.exception.MemberNotFoundException;
import spring.vo.Member;

public class ChangePasswordService { // 비밀번호 변경 기능
	
	private MemberDao dao; // = new MemberDao();
	
	
	//setter 매서드를 통한 주입
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}




	public void changePassword(String email, String oldPassword,String newPassword) {
		
		Member member = dao.selectByEmail(email);
		
		if(member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPassword, newPassword);		
		dao.update(member);
		
	}




}
