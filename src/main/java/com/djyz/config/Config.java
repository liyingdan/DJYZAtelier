package com.djyz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Import(WebMvcConfiguration.class)
@ComponentScan(basePackages = "com.djyz")
@ImportResource("classpath:application-mybatis.xml")
//@ImportResource("classpath:redis-context.xml")

public class Config {

}
