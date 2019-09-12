package com.ltsk.whcg.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
// 加上这个注解，使得支持事务
@EnableTransactionManagement
@MapperScan(basePackages = "com.ltsk.whcg.base.mapper", sqlSessionTemplateRef = "baseSqlSessionTemplate")
public class BaseConfig {

	@Bean(name = "baseDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.base")
	//当系统中有多个数据源时，必须有一个数据源为主数据源，使用@Primary修饰。 
	@Primary
	public DataSource setDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "baseTransactionManager")
	@Primary
	public DataSourceTransactionManager setTransactionManager(@Qualifier("baseDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "baseSqlSessionFactory")
	@Primary
	public SqlSessionFactory setSqlSessionFactory(@Qualifier("baseDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		//开启驼峰式命名法对应ENTITY类 userName 对应数据库 user_name
		configuration.setMapUnderscoreToCamelCase(true);
		bean.setConfiguration(configuration);
		return bean.getObject();
	}

	@Bean(name = "baseSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate setSqlSessionTemplate(
			@Qualifier("baseSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
