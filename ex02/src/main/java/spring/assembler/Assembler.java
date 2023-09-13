package spring.assembler;

import spring.dao.MemberDao;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;

public class Assembler {//객체조립기

	private MemberDao dao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	
	public Assembler() {		
		this.dao = new MemberDao();
		this.regSvc = new MemberRegisterService(dao); //주입
		this.pwdSvc = new ChangePasswordService();
		this.pwdSvc.setDao(dao);
	}



	public MemberDao getDao() {
		return dao;
	}
	public MemberRegisterService getregSvc() {
		return regSvc;
	}
	public ChangePasswordService getpwdSvc() {
		return pwdSvc;
	}
	
	
	
	
}
