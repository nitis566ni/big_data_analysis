package com.prushal.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prushal.model.Employee;
import com.prushal.model.EmployeeRoles;
import com.prushal.model.Merchant;
import com.prushal.model.PotentialCorporateProjects;
import com.prushal.model.PotentialMerchants;
import com.prushal.model.Project;
import com.prushal.repository.EmployeeRepository;
import com.prushal.repository.EmployeeRoleRepository;
import com.prushal.repository.MerchantRepository;
import com.prushal.repository.PotentialCorporateProjectsRepository;
import com.prushal.repository.PotentialMerchantsRespository;
import com.prushal.repository.ProjectRepository;

@Service
public class LoginService {

	@Autowired
	EmployeeRepository repository;

	@Autowired
	ProjectRepository pRepository;

	@Autowired
	PotentialCorporateProjectsRepository pcRepository;

	@Autowired
	MerchantRepository mRepository;

	@Autowired
	PotentialMerchantsRespository pmRespository;

	@Autowired
	EmployeeRoleRepository erepository;

	public String check(String username, String password) {
		Employee emp = repository.findByUsername(username);
		System.out.println(username+"-"+password);
		System.out.println(emp);
		if (emp != null) {			
			if (emp.getPassword().equals(password)) {
				return "Success";
			} else
				return "Incorrect Password";
		} else
			return "User Does Not Exist";
	}

	public long getProjectCount() {
		List<Project> projects = pRepository.findAll();
		long count = 0;
		for (int i = 0; i < projects.size(); i++) {
			count++;
		}
		return count;
	}

	public long getPotentialProjectCount() {
		List<PotentialCorporateProjects> cprojects = pcRepository.findByIsApproved(false);
		long count = 0;
		for (int i = 0; i < cprojects.size(); i++) {
			count++;
		}
		return count;
	}

	public long getMerchantsCount() {
		List<Merchant> merchants = mRepository.findAll();
		long count = 0;
		for (int i = 0; i < merchants.size(); i++) {
			count++;
		}
		return count;
	}

	public long getPotentialMerchantsCount() {
		List<PotentialMerchants> pmerchants = pmRespository.findByIsApproved(false);
		long count = 0;
		for (int i = 0; i < pmerchants.size(); i++) {
			count++;
		}
		return count;
	}
	
	public Employee getUserByEmailId(String emailId) {

		return repository.findByEmailId(emailId);
	}

	public EmployeeRoles getRolesByEmailId(String emailId) {

		return erepository.findByEmployeeID(repository.findByEmailId(emailId).getEmployeeID());
	}

	public Employee getUser(String username) {

		return repository.findByUsername(username);
	}

	public EmployeeRoles getRoles(String username) {

		return erepository.findByEmployeeID(repository.findByUsername(username).getEmployeeID());
	}
}
