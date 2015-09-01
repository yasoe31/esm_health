package com.yan.pshealth.controller;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import ch.qos.logback.classic.Logger;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.yan.pshealth.config.TestConfig;
import com.yan.pshealth.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigContextLoader.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("employee.xml")
@WebAppConfiguration
@Transactional
public class EmployeeControllerTest {

	private static final Logger LOGGER = (ch.qos.logback.classic.Logger) LoggerFactory
			.getLogger(EmployeeControllerTest.class);

	@Autowired
	EmployeeController employeeController;

	@Test
	public void test_saveEmployee() {

		String string = "{\"employee\":{\"name\":\"yan\"},\"skills\":{\"skill\":[{\"name\":\"JAVA\"},{\"name\":\"MVC\"}]}}";

		Employee employee = employeeController.saveEmployee(string);

		Assert.assertEquals("yan", employee.getName());
		Assert.assertEquals(2, employee.getSkills().size());

	}

	@Test
	public void test_saveEmployee_without_name() throws Exception {

		String string = "{\"employee\":{\"name\":\"\"},\"skills\":{\"skill\":[{\"name\":\"JAVA\"},{\"name\":\"MVC\"}]}}";

		Employee employee = employeeController.saveEmployee(string);
		
		Assert.assertEquals("", employee.getName());

	}

}
