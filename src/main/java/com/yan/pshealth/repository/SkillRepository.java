package com.yan.pshealth.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yan.pshealth.model.Employee;
import com.yan.pshealth.model.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer>{

	List<Employee> findByName(String name);
}
