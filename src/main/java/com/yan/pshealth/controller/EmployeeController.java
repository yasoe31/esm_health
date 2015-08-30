package com.yan.pshealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yan.pshealth.model.Employee;
import com.yan.pshealth.service.EmployeeService;
import com.yan.pshealth.service.SkillService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	SkillService skillService;

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	@ResponseBody
	public Employee saveEmployee(@RequestBody String string) {

		return employeeService.saveEmployee(string);

	}	

	@RequestMapping(value = "/")
	public String indexPage() {

		return "index";
	}
	
	@RequestMapping(value="/search")
	public String search() {
		
		return "search";
	}
	
	@RequestMapping(value="/searchEmployeeBySkill",method=RequestMethod.GET)
	@ResponseBody
	public List<Employee> searchEmployeeBySkill(@RequestParam String skill) {
		
		return skillService.findByName(skill);

	}

}
