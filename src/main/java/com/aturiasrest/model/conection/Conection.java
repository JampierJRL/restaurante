package com.aturiasrest.model.conection;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.aturiasrest.model.repository")
@ComponentScan("com.aturiasrest*")
public class Conection {

	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter japAdapter = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(japAdapter);
		factory.setPackagesToScan(new String[] { "com.aturiasrest.model.entity" });
		factory.setDataSource(dataSource());
		factory.setJpaProperties(addProperties());
		factory.afterPropertiesSet();
		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		return factory.getObject();

	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driver = new DriverManagerDataSource();
		driver.setDriverClassName("com.mysql.cj.jdbc.Driver");

		driver.setUrl(
				"jdbc:mysql://localhost:3306/dbasturiasrest?useSSL=false&serverTimezone=America/Lima&allowPublicKeyRetrieval=true");
		driver.setUsername("root");
		driver.setPassword("janpier159");

		return driver;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		EntityManagerFactory emf = entityManagerFactory();
		return new JpaTransactionManager(emf);
	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource datasource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
		return jdbcTemplate;
	}

	Properties addProperties() {
		Properties propiedad = new Properties();
		propiedad.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

		// #CREAR LAS TABLAS
		propiedad.setProperty("hibernate.hbm2ddl.auto", "update");
		// #VALIDA TABLAS
		// propiedad.setProperty("hibernate.hbm2ddl.auto", "validate");
		//Visualizar las consultas ejecutas en SQL
		propiedad.setProperty("hibernate.show_sql", "true");
		//Parte de la consulta que permite visualizar el formato en SQL
		propiedad.setProperty("hibernate.format_sql", "true");
		return propiedad;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
