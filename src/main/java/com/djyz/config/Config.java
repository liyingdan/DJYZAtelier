package com.djyz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description //TODO
 * @ProjectName: DJYZAtelier
 * @Package: com.djyz.config
 * @ModifiedTime
 */
@Import(WebMvcConfiguration.class)
@ComponentScan(basePackages = "com.djyz")
@ImportResource("classpath:application-mybatis.xml")
public class Config {

}
