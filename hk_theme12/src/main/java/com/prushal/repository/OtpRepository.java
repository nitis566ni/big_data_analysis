package com.prushal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prushal.model.Otp;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Long>  {
	
}
