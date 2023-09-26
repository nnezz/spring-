package com.green.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.green.vo.BoardVO;
@Repository
public class BoardDao {// DB 연결해서 쿼리를 보내고 데이터를 받기 위한 클래스

	private JdbcTemplate jdbcTemplate;
	
	public BoardDao(JdbcTemplate jdbcTemplate) {	
		this.jdbcTemplate = jdbcTemplate;
}
	
	private RowMapper<BoardVO> mapper = new RowMapper<BoardVO>() {

		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO bVo = 
					BoardVO.builder()
					.boardcontent(rs.getString("boardcontent"))
					.boardcount(rs.getInt("boardcount"))
					.boardnum(rs.getInt("boardnum"))
					.boardregdate(rs.getDate("boardregdate"))
					.boardtitle(rs.getString("boardtitle"))
					.boardwriter(rs.getString("boardwriter"))
					.build();
			
			return bVo;
		}		
	};
	
	//list 출력
	public List<BoardVO> selectAll() {
	
		String sql = "SELECT * FROM springboard order by boardnum desc";			
		List<BoardVO> list = jdbcTemplate.query(sql,mapper);	
		return list;
	}
	
	

	
	
}
