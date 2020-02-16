package com.prushal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prushal.model.DocumentUploads;

public interface DocumentUploadRepository extends JpaRepository<DocumentUploads, Long> {
	DocumentUploads findByUserType(String userType);
}
