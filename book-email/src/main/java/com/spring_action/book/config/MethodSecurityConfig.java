package com.spring_action.book.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import com.spring_action.book.security.SpittlePermissionEvaluator;


/**
 * 启用基于注解的方法安全性
 * @author ThinkPad
 *
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration{

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		DefaultMethodSecurityExpressionHandler expressionHandler = 
				new DefaultMethodSecurityExpressionHandler();
		expressionHandler.setPermissionEvaluator(new SpittlePermissionEvaluator());
		return expressionHandler;
		
	}
}
