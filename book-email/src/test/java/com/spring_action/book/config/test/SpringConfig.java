package com.spring_action.book.config.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration   //表明该类为Java配置类
@ComponentScan   //表明启用组件扫描，对应的XML配置为<context:component-scan base-package="扫描范围"/>
public class SpringConfig {

}
