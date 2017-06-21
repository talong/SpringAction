package com.spring_action.book.client;

import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.spring_action.book.service.EmailService;

public class ClientGetRmi {

	/**
	 * 使用RmiProxyFactoryBean引用EmailService
	 * 的RMI服务
	 * @return
	 */
	@Bean
	public RmiProxyFactoryBean emailService() {
		RmiProxyFactoryBean rmiProxy = 
				new RmiProxyFactoryBean();
		rmiProxy.setServiceUrl("rmi:localhost/EmailService");  //EmailService服务名
		rmiProxy.setServiceInterface(EmailService.class);
		
		return rmiProxy;
	
	}
	
	
	/**
	 * 使用HttpInvokerProxyFactoryBean引用EmailService
	 * 的RMI服务
	 * @return
	 */
	@Bean
	public HttpInvokerProxyFactoryBean emailServiceOfHttp() {
		HttpInvokerProxyFactoryBean proxy = 
				new HttpInvokerProxyFactoryBean();
		proxy.setServiceUrl("http://localhost:8080/Spitter/email.service");  //EmailService服务名
		proxy.setServiceInterface(EmailService.class);
		
		return proxy;
	
	}
}
