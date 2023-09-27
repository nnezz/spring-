package com.green.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.db.DBManger;
import com.green.vo.MemberVO;

public class MemberDAO {
	
	
	private MemberDAO() {}
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
		
	//mybatis 없는 오리지널
	//전체 데이터 조회하는 기능
	
	public List<MemberVO> selectAll(){
		List<MemberVO> lists = new ArrayList<>();
		
		String sql = "select * from members";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		
		try {
			conn = DBManger.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				MemberVO member = new MemberVO();
				
				member.setId(rs.getLong("id"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setRegdate(rs.getDate("regdate"));
				
				lists.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManger.close(conn, stmt, rs);
		}
		return lists;
	}
}
