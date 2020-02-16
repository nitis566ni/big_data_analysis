package com.prushal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prushal.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmployeeID(String employeeID);
	
	Employee findByMobileNumber(String mobileNumber);
	
	Employee findByEmailId(String emailId);
	
	Employee findByUsername(String username);
	
}
