package com.inswave.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScans(
  {
    @MapperScan(
      basePackages = {"com.inswave.**.dao"},
      sqlSessionFactoryRef = "sqlSessionFactoryHikariEvent"
    )
  }
)
public class HiKariEventPoolDataSourceConfiguration {



  /**
   * Hikari DataSource
   *
   * @return the data source
   */
  @ConfigurationProperties(prefix = "spring.datasource-hikari-event")
  @Bean(name = "dataSourceHikariEventDb")
  public DataSource dataSourceHikariEventDb(){
    return DataSourceBuilder.create()
            .type(HikariDataSource.class)
            .build();
  }

  /**
   * Sql session factory sql session factory.
   *
   * @param dataSource the data source
   * @return the sql session factory
   * @throws Exception the exception
   */
  @Bean("sqlSessionFactoryHikariEvent")
  public SqlSessionFactory sqlSessionFactoryHikariEvent(
          @Qualifier("dataSourceHikariEventDb") DataSource dataSource
  )throws Exception{



    SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
    sqlSessionFactory.setDataSource(dataSource);

	sqlSessionFactory.setConfigLocation(new DefaultResourceLoader().getResource("classpath:/sqlmap/mybatis-config.xml"));
	sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/sqlmap/context/**/*.xml"));

    return sqlSessionFactory.getObject();
  }

}
