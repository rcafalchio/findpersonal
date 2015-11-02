package com.findpersonal.findpersonalws.config.repository;

import javax.sql.DataSource;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages = { "com.findpersonal.findpersonaljpa.entity" })
@EnableJpaRepositories(basePackages = { "com.findpersonal.findpersonaljpa.repository" })
@EnableTransactionManagement
public class RepositoryConfiguration {

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(getClass().getPackage().getName());
		factory.setDataSource(dataSource);
		

		return factory;
	}

	@Bean
	DataSource dataSource() {
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		DataSource dataSource = dsLookup.getDataSource("jdbc/findpersonal");
		
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	    dataSource.setUrl("jdbc:mysql://localhost:3306/findpersonaldb");
//	    dataSource.setUsername("root");
//	    dataSource.setPassword("root");
//	    Properties properties = new Properties();
//	    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//	    dataSource.setConnectionProperties(properties);
		return dataSource;
	}

	@Bean
	JpaTransactionManager transactionManager() {
		return new JpaTransactionManager();
	}
}
