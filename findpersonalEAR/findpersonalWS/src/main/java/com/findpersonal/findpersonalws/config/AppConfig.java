package com.findpersonal.findpersonalws.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(value = "com.findpersonal")
@EnableWebMvc
/**
 * Configurações do Spring
 * 
 * @author Ricardo
 * @since 10 de ago de 2015
 */
public class AppConfig {
}