package spring.printer;

import java.util.List;

import spring.dao.MemberDao;
import spring.vo.Member;

public class MemberListPrinter {
	
	private MemberDao memberDao;   // 모든 회원 정보 알아오기
	private MemberPrinter printer; // 회원 정보 출력하기
	
	// 외부에서 만들어진 두 객체를 생성자를 통해서 전달(주입)받는다.
	public MemberListPrinter(MemberDao memberDao,MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll() {// 모든 회원 정보를 출력하는 메서드
//		Collection<Member> members= memberDao.selectAll();
		List<Member> members= memberDao.selectAll();
		for(Member m:members) {
			printer.print(m);
		}
	
	}

}
