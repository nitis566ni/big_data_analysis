package com.prushal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prushal.model.PotentialCorporateProjects;

@Repository
public interface PotentialCorporateProjectsRepository extends JpaRepository<PotentialCorporateProjects, Long> {

	PotentialCorporateProjects findByMobileNumber(String mobileNumber);
	
	PotentialCorporateProjects findByEmailId(String emailId);
	
	List<PotentialCorporateProjects> findByIsApproved(boolean status);
}
