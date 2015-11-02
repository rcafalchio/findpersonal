package com.findpersonal.findpersonalws.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configurações do Spring
 * 
 * @author Ricardo
 * @since 10 de ago de 2015
 */
@Configuration
@EnableWebMvc
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan(basePackages = {
"com.findpersonal"}, excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.findpersonal.findpersonalws.test.*") )
public class AppConfig {
	
	
}