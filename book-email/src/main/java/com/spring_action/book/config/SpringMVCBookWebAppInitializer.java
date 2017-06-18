package com.spring_action.book.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 我们希望DispatcherServlet加载包含Web组件的bean，如控制器、试图解析器以及处理器映射，
 * 而ContectLoaderListener要加载应用中的其他bean。这些bean通常是驱动应用后端的中间层和数据层组件。
 * @author ThinkPad
 *
 */

public class SpringMVCBookWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
