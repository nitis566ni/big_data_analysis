package com.prushal.rest.service;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.prushal.exception.CustomErrorException;
import com.prushal.model.Feedback;
import com.prushal.repository.FeedbackRepository;
import com.prushal.util.ErrorCodes;

@Service
public class FeedbackService {

	@Autowired
	FeedbackRepository repository;

	public Feedback create(@Valid Feedback fb) {
		try {
			return repository.save(fb);
		} catch (DataIntegrityViolationException e) {
			String[] msg = e.getRootCause().toString().split(":");
			String[] errMsg = msg[1].split("for");
			throw new CustomErrorException("Feedback", errMsg[0], ErrorCodes.DUPLICATE_ENTRY.getCode());
		} catch (ConstraintViolationException e) {
			String[] msg = e.getMessage().split("=");
			String[] errMsg = msg[1].split(",");
			throw new CustomErrorException("Feedback", errMsg[0], ErrorCodes.VALIDATION_FAILED.getCode());
		}
	}
}
