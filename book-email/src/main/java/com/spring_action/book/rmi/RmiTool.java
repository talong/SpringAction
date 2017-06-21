package com.spring_action.book.rmi;

import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.spring_action.book.service.EmailService;

public class RmiTool {

	/**
	 * 使用RmiServiceExporter将EmailService发布为Rmi服务
	 * @param emailService
	 * @return
	 */
	@Bean
	public RmiServiceExporter rmiExporter(EmailService emailService) {
		RmiServiceExporter rmiExporter = new RmiServiceExporter();
		rmiExporter.setService(emailService);
		rmiExporter.setServiceName("EmailService");
		rmiExporter.setServiceInterface(EmailService.class);
		
		//rmiExporter.setRegistryHost("rmi.springAction.com");
		//rmiExporter.setRegistryPort(1099);
		
		return rmiExporter;
	}
}
