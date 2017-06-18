package com.spring_action.book.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;

public class MyServletInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		Dynamic myServlet =
				servletContext.addServlet("myServlet", MyServlet.class);
		
		myServlet.addMapping("/custom/**");
	}

}
