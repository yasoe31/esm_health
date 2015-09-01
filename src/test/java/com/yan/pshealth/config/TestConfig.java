package com.yan.pshealth.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.yan.pshealth.controller.EmployeeController;
import com.yan.pshealth.service.EmployeeService;
import com.yan.pshealth.service.EmployeeServiceImpl;
import com.yan.pshealth.service.SkillService;
import com.yan.pshealth.service.SkillServiceImpl;

@Configuration
@EnableJpaRepositories("com.yan.pshealth.repository")
@EnableTransactionManagement
public class TestConfig {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:mem:paging");
		dataSource.setUsername("sa");
		dataSource.setPassword("");

		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(
			EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager(
				emf);
		return transactionManager;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.yan.pshealth" });

		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(jpaVendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");		
		return properties;
	}
	
	@Bean
	EmployeeController employeeController(){
		return new EmployeeController();
	}
	
	@Bean
	EmployeeService employeeService(){
		return new EmployeeServiceImpl();
	}
	
	@Bean
	SkillService skillService(){
		return new SkillServiceImpl();
	}

}
