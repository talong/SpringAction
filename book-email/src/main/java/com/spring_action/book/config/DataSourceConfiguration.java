package com.spring_action.book.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
public class DataSourceConfiguration {

	@Profile("development")
	@Bean
	public DataSource embeddedDataSource() {
		return new EmbeddedDatabaseBuilder()
		.setType(EmbeddedDatabaseType.HSQL)
		.addScript("classpath:schema.sql")
		.addScript("classpath:test-data.sql")
		.build();
	}
	
	@Profile("qa")
	@Bean
	public DataSource Data() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("");
		ds.setUrl("");
		ds.setUsername("");
		ds.setPassword("");
		ds.setInitialSize(5);
		ds.setMaxActive(10);
		return ds;
	}
	
	
	@Profile("production")
	@Bean
	public DataSource dataSource() {
		JndiObjectFactoryBean jndiObjectFactoryBean = 
				new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName("jdbc/SpittrDS");
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
		
		return (DataSource) jndiObjectFactoryBean.getObject();
	}
}
