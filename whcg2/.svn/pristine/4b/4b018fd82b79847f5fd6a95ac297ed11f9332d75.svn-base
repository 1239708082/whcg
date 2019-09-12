package com.ltsk.whcg.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
// 加上这个注解，使得支持事务
@EnableTransactionManagement
@MapperScan(basePackages = "com.ltsk.whcg.digital.mapper", sqlSessionTemplateRef = "digitalSqlSessionTemplate")
public class DigitalConfig {

		@Bean(name = "digitalDataSource")
		@ConfigurationProperties(prefix = "spring.datasource.digital")
		public DataSource setDataSource() {
			return DataSourceBuilder.create().build();
		}

		@Bean(name = "digitalTransactionManager")
		public DataSourceTransactionManager setTransactionManager(@Qualifier("digitalDataSource") DataSource dataSource) {
			return new DataSourceTransactionManager(dataSource);
		}

		@Bean(name = "digitalSqlSessionFactory")
		public SqlSessionFactory setSqlSessionFactory(@Qualifier("digitalDataSource") DataSource dataSource)
				throws Exception {
			SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
			bean.setDataSource(dataSource);
			return bean.getObject();
		}

		@Bean(name = "digitalSqlSessionTemplate")
		public SqlSessionTemplate setSqlSessionTemplate(
				@Qualifier("digitalSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
			return new SqlSessionTemplate(sqlSessionFactory);
		}

	}


