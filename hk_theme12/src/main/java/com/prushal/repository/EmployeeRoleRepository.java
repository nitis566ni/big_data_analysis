package com.prushal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prushal.model.EmployeeRoles;

public interface EmployeeRoleRepository extends JpaRepository<EmployeeRoles, Long> {

	EmployeeRoles findByEmployeeID(String employeeID);
}
