package spring.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import spring.dao.MemberDao;

@Configuration
@Profile("real")
public class DsRealConfig {
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		
		try {
			ds.setDriverClass("oracle.jdbc.OracleDriver");
		} catch (PropertyVetoException e) {		
			e.printStackTrace();
		}
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUser("GREEN99");
		ds.setPassword("1234");
		
		
		
		return ds;
	}	
}
