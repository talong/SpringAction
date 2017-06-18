package com.spring_action.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 当DispatcherServlet启动的时候，它会创建应用上下文，并加载配置文件或配置类中所声明的bean。
 * WebConfig就是DispatcherServlet启动时要加载的内容。
 * @author ThinkPad
 *
 */

@Configuration   //表明该类为Java配置类
@EnableWebMvc    //启用SpringMVC
@ComponentScan("com.Spring_action.book") //启用组件扫描
public class WebConfig extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver viewResoler() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/*");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
	
	/**
	 * 配置静态资源的处理
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
	}
}
