package com.green.dao;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.green.vo.MemberVO;

public class MemberDAOForMybatis {
	
	
	private MemberDAOForMybatis() {}
	private static MemberDAOForMybatis dao = new MemberDAOForMybatis();
	public static MemberDAOForMybatis getInstance() {
		return dao;
	}
		
	//mybatis 를 사용하기 위해서는 sqlSessionFactory 객체가 필요하다.
	//xml  설정  (configuration)파일을 읽어서 sqlSessionFactory 를 빌드
	// 빌드된 sqlSessionFactory 객체를 통해서 sqlsession 객체를 생성하고
	//sqlsession 객체를 통해서 mapper 에 미리 세팅된 쿼리문을 읽어서 db연결
	
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	private static SqlSessionFactory getFactory() {
		if(sqlSessionFactory == null) {
			
			try {
				String resource = "com/green/mybatis/config/sqlconfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return sqlSessionFactory;
	}
	
	
	
	public List<MemberVO> selectAll(){
		List<MemberVO> lists = null;
		
		sqlSessionFactory = getFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		lists = session.selectList("com.green.mybatis.mapper.member.selectAll");
		
		
		return lists;
	}
	
	
	public List<HashMap<String,String>> selectAllToMap(){
		//해시맵은 순서에 상관없이 데이터를 가져온다.
		
		List<HashMap<String,String>> lists = null;
		
		sqlSessionFactory = getFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		lists = session.selectList("com.green.mybatis.mapper.member.selectAllToMap");
		
		
		return lists;
	}
}
