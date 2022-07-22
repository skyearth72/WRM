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
 * Event DB 의 Transaction Config
 * @author Shin Seoung Ho
 *
 */
@Configuration
@EnableTransactionManagement
@DependsOn(value = {"dataSourceHikariEventDb"})
public class EventDbTransactionConfig {

	/**
	 * Event 용의 계정으로 접속한 Datasource
	 */
	@Autowired
	@Qualifier("dataSourceHikariEventDb")
	private DataSource dataSourceOfEventDb;
	

	/**
	 * Event 용의 계정으로 접속한 Datasource 에 대한 Transaction Manager
	 * @return
	 */
	@Bean(name={"transactionManagerOfEventDb"})
	public PlatformTransactionManager transactionManagerOfEventDb() {
		return new DataSourceTransactionManager(dataSourceOfEventDb);
	}
}
