package spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import spring.vo.Member;

public class MapperSqlToMember implements RowMapper<Member>{

	public void mapper() {
		//매핑규칙
		//db에서 가져온 데이터를 java 데이터로 옮겨 담는 방법
	}

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		// 실제 매핑 규칙을 작성해야할 메서드
		// -while문 내부에 작성해야할 내용들
		Member member = new Member(
				rs.getString("email"),
				rs.getString("password"),
				rs.getString("name"),
				rs.getTimestamp("regdate"));
		
		member.setId(rs.getLong("id"));
		
		return member;
	}
}
