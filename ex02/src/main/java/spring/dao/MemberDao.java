package spring.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import spring.vo.Member;

public class MemberDao {//DB 연결해서 쿼리를 보내고 데이터를 받기 위한 클래스
	
	private static long nextId = 0;
	
	private Map<String, Member> map = new HashMap<>();
	
	public void insert (Member member) {
		member.setId(++nextId);;
		map.put(member.getEmail(), member);
	}
	public void update (Member member) {		
		map.put(member.getEmail(), member);
	}
	public Member selectByEmail (String email) {		
		return map.get(email);
	}
	
	public Collection<Member> selctAll(){
		return map.values();
	}
	
}
