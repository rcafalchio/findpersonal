package com.findpersonal.findpersonalws.test.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.findpersonal.findpersonalws.config.AppConfig;
import com.findpersonal.findpersonalws.config.SpringMvcInitializer;
import com.findpersonal.findpersonalws.config.SpringSecurityInitializer;
import com.findpersonal.findpersonalws.config.repository.RepositoryConfiguration;

@Configuration
@ComponentScan(basePackages = {"com.findpersonal"}, excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = AppConfig.class),
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = RepositoryConfiguration.class),
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = SpringSecurityInitializer.class),
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = SpringMvcInitializer.class)})

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
