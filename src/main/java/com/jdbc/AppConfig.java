package com.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/firstdb"); 
			dataSource.setUsername("root"); 
			dataSource.setPassword("alok@25");
			return dataSource;
	}
	@Bean
	public Repo Repo(DataSource dataSource) {
	return new Repo(dataSource);
	}
	

}
