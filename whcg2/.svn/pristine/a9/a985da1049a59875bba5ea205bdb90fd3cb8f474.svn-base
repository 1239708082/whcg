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
@MapperScan(basePackages = "com.ltsk.whcg.gas.mapper", sqlSessionTemplateRef = "gasSqlSessionTemplate")
public class GasConfig {

		@Bean(name = "gasDataSource")
		@ConfigurationProperties(prefix = "spring.datasource.gas")
		public DataSource setDataSource() {
			return DataSourceBuilder.create().build();
		}

		@Bean(name = "gasTransactionManager")
		public DataSourceTransactionManager setTransactionManager(@Qualifier("gasDataSource") DataSource dataSource) {
			return new DataSourceTransactionManager(dataSource);
		}

		@Bean(name = "gasSqlSessionFactory")
		public SqlSessionFactory setSqlSessionFactory(@Qualifier("gasDataSource") DataSource dataSource)
				throws Exception {
			SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
			bean.setDataSource(dataSource);
			return bean.getObject();
		}

		@Bean(name = "gasSqlSessionTemplate")
		public SqlSessionTemplate setSqlSessionTemplate(
				@Qualifier("gasSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
			return new SqlSessionTemplate(sqlSessionFactory);
		}

	}


