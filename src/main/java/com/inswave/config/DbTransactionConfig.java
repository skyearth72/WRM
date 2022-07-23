package com.inswave.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DB 의 Transaction Config
 * @author Shin Seoung Ho
 *
 */
@Configuration
@EnableTransactionManagement
@DependsOn(value = {"dataSource"})
public class DbTransactionConfig {

	/**
	 * Event 용의 계정으로 접속한 Datasource
	 */
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	

	/**
	 * Event 용의 계정으로 접속한 Datasource 에 대한 Transaction Manager
	 * @return
	 */
	@Bean(name={"dbTransactionManager"})
	public PlatformTransactionManager transactionManagerOfEventDb() {
		return new DataSourceTransactionManager(dataSource);
	}
}
