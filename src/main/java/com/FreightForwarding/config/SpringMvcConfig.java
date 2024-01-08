package com.FreightForwarding.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = "classpath:spring-mvc.xml")
public class SpringMvcConfig {
}
