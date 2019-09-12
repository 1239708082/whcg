package com.ltsk.whcg.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//加上这个注解，使得支持事务
@EnableTransactionManagement
@MapperScan(basePackages = "com.ltsk.whcg.bridgeDefect.mapper", sqlSessionTemplateRef = "bridgeDefectSqlSessionTemplate")
public class BridgeDefectConfig {
	@Bean(name = "bridgeDefectDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.bridgeDefect")
	//当系统中有多个数据源时，必须有一个数据源为主数据源，使用@Primary修饰。 
	public DataSource setDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "bridgeDefectTransactionManager")
	public DataSourceTransactionManager setTransactionManager(@Qualifier("bridgeDefectDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "bridgeDefectSqlSessionFactory")
	public SqlSessionFactory setSqlSessionFactory(@Qualifier("bridgeDefectDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		//开启驼峰式命名法对应ENTITY类 userName 对应数据库 user_name
		configuration.setMapUnderscoreToCamelCase(true);
		bean.setConfiguration(configuration);
		return bean.getObject();
	}

	@Bean(name = "bridgeDefectSqlSessionTemplate")
	public SqlSessionTemplate setSqlSessionTemplate(
			@Qualifier("bridgeDefectSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
