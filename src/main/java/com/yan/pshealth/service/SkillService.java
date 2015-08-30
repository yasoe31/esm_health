package com.yan.pshealth.service;

import java.util.List;

import com.yan.pshealth.model.Employee;

public interface SkillService {
	
	List<Employee> findByName(String name);

}
