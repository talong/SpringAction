package com.spring_action.book.rmi;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

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
	
	/**
	 * 使用HttpInvokerServiceExporter将EmailService发布为Rmi服务
	 * @param service
	 * @return
	 */
	@Bean
	public HttpInvokerServiceExporter 
	     httpExportedEmailService(EmailService service) {
		HttpInvokerServiceExporter exporter = 
				new HttpInvokerServiceExporter();
		exporter.setService(service);
		exporter.setServiceInterface(EmailService.class);
		return exporter;
	}
	
	/**
	 * 设置针对rmi访问的映射
	 * @return
	 */
	@Bean
	public HandlerMapping httpInvokerMapping() {
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		Properties mappings = new Properties();
		mappings.setProperty("email.service", "httpExportedEmailService");
		mapping.setMappings(mappings);
		return mapping;
	}
	
}
