package com.spring_action.book.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration   //表明该类为Java配置类
@ComponentScan(basePackages={"booker"},excludeFilters={@Filter(type=FilterType.ANNOTATION,
value=EnableWebMvc.class)})   
public class RootConfig {

}
