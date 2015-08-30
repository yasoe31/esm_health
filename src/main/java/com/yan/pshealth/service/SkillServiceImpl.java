package com.yan.pshealth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yan.pshealth.model.Employee;
import com.yan.pshealth.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	SkillRepository skillRepository;

	public List<Employee> findByName(String name) {

		return skillRepository.findByName(name);
	}

}
