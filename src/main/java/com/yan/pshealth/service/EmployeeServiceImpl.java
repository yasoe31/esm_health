package com.yan.pshealth.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yan.pshealth.model.Employee;
import com.yan.pshealth.model.Skill;
import com.yan.pshealth.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee saveEmployee(String string) {

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = null;

		try {
			jsonNode = objectMapper.readTree(string);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Employee employee = objectMapper.convertValue(jsonNode.get("employee"),
				Employee.class);
		
		Set<Skill> setSkill = new HashSet<Skill>();
		Set<Employee> setEmployee = new HashSet<Employee>();

		if (jsonNode.path("skills").path("skill").isArray()) {
			for (JsonNode skill : jsonNode.path("skills").path("skill")) {
				setSkill.add(objectMapper.convertValue(skill,
						Skill.class));
			}
		}
		
		setEmployee.add(employee);
		employee.setSkills(setSkill);
		
		for (Skill skill : setSkill) {
			skill.setEmployees(setEmployee);
		}

		return employeeRepository.save(employee);
	}	

}
