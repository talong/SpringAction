package com.spring_action.book.client;

import org.springframework.context.annotation.Bean;
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
}
