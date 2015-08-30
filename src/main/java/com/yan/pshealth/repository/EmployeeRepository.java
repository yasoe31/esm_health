package com.yan.pshealth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yan.pshealth.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	Employee findByName(String name);
}
