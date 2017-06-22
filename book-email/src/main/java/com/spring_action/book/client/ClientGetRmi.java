package com.spring_action.book.client;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring_action.book.domain.Email;
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
	
	
	public Profile fetchFacebookProfile(String id) {
		
		HttpClient client = HttpClients.createDefault();
		
		HttpGet request = new HttpGet("http://graph.facebook.com/" + id);
		request.setHeader("Accept", "application/json");
		
		try {
			HttpResponse response = client.execute(request);
		    HttpEntity entity = response.getEntity();
		    ObjectMapper mapper = new ObjectMapper();
		
		    return mapper.readValue(entity.getContent(), Profile.class);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	
	public Profile fetchFacebookProfileRestTemplate(String id) {
		RestTemplate rest = new RestTemplate();
		return rest.getForObject("http://graph.facebook.com/{email}", 
				Profile.class, id);
	}
	
	public void updateEmail(Email email) {
		RestTemplate rest = new RestTemplate();
		String url = "http://localhost:8080/email-api/emailes/"
				+ email.getId();
		rest.put(URI.create(url), email);
	}
	
	public void deleteEmail(long id) {
		RestTemplate rest = new RestTemplate();
		rest.delete("http://localhost:8080/email-api/emailes/{id}", id);
	}
	
	public Email postEmailForObject(Email email) {
		RestTemplate rest = new RestTemplate();
		return rest.postForObject(
				"http://localhost:8080/email-api/emailes", 
				email, Email.class);
	}
	
}
