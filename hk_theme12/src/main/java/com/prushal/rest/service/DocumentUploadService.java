package com.prushal.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prushal.exception.ResourceNotFoundException;
import com.prushal.model.DocumentUploads;
import com.prushal.repository.DocumentUploadRepository;

@Service
public class DocumentUploadService {

	@Autowired
	DocumentUploadRepository repository;

	public DocumentUploads getPaths(String userType) {
		if (repository.findByUserType(userType) != null) {
			return repository.findByUserType(userType);
		} else
			throw new ResourceNotFoundException("DocumentUploads", "User Type", userType);
	}

}
