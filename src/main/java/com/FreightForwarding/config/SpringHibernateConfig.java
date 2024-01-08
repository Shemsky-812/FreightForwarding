package com.FreightForwarding.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = "classpath:spring-hibernate.xml")
public class SpringHibernateConfig {
}
