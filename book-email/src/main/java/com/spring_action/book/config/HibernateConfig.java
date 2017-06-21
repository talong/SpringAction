package com.spring_action.book.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

public class HibernateConfig {

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		sfb.setDataSource(dataSource);
		sfb.setPackagesToScan(new String[] {"com.spring_action.book.domain"});
		Properties props = new Properties();
		props.setProperty("dialect", "org.hibernate.dialect.HSQLDialect");
		sfb.setHibernateProperties(props);
		return sfb;
	}
}
