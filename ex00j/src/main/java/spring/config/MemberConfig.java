package spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import spring.dao.MemberDao;

@Configuration
@EnableTransactionManagement   //<tx:annotation-driventransaction-manager="transactionManager" />
public class MemberConfig {
	
	@Autowired
	private DataSource dataSource;
	
	/*
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		
		try {
			ds.setDriverClass("oracle.jdbc.OracleDriver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUser("HR");
		ds.setPassword("1234");
		
		
		
		return ds;
	}
	*/
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager txMgr = new DataSourceTransactionManager();
		txMgr.setDataSource(dataSource);
		return txMgr;
	}
	
	
	
	@Bean
	public JdbcTemplate jdbcTemplate() {			
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public MemberDao memberDao() {
		
		return new MemberDao(jdbcTemplate());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
