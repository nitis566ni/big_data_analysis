package com.prushal.rest.service;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prushal.exception.CustomErrorException;
import com.prushal.exception.ResourceNotFoundException;
import com.prushal.model.MerchantLimit;
import com.prushal.model.MerchantTopupLimit;
import com.prushal.repository.MerchantLimitRepository;
import com.prushal.repository.MerchantRepository;
import com.prushal.repository.MerchantTopupLimitRepository;
import com.prushal.repository.ProjectRepository;
import com.prushal.util.ErrorCodes;

@Service
public class MerchantTopupLimitService {

	@Autowired
	MerchantTopupLimitRepository mtlrepository;

	@Autowired
	MerchantLimitRepository mlrepository;

	@Autowired
	ProjectRepository prepository;

	@Autowired
	MerchantRepository mrepository;

	@Autowired
	ProjectService service;

	public MerchantTopupLimit createLimit(@Valid MerchantTopupLimit limit) {

		String projectID = limit.getProjectID();

		if (service.projectType(projectID).equalsIgnoreCase("SINGLE")) {
			throw new CustomErrorException("MerchantLimit", ErrorCodes.NOT_ALLOWED.getDescription(),
					ErrorCodes.NOT_ALLOWED.getCode());
		}

		MerchantTopupLimit lim = mtlrepository.save(limit);

		String merchantID = lim.getMerchantID();

		if (mlrepository.findByMerchantID(merchantID) != null) {
			MerchantLimit mlim = mlrepository.findByMerchantID(merchantID);

			BigDecimal oldLimitAmount = mlim.getMerchantLimit();
			BigDecimal newLimitAmount = oldLimitAmount.add(lim.getActualTopupPaid());

			mlim.setMerchantLimit(newLimitAmount);
			mlrepository.save(mlim);
		} else {

			MerchantLimit mlim = new MerchantLimit();
			mlim.setMerchantID(merchantID);
			mlim.setMerchantLimit(lim.getActualTopupPaid());

			mlrepository.save(mlim);
		}

		return lim;
	}

	public List<MerchantTopupLimit> getAll() {
		return mtlrepository.findAll();
	}

	public List<MerchantLimit> getLimits() {
		return mlrepository.findAll();
	}

	public MerchantLimit getLimitByMerchantId(String merchantID) {
		if (mrepository.findByMerchantID(merchantID) != null) {
			if (prepository.findByProjectID(mrepository.findByMerchantID(merchantID).getProjectID()).getProjectType()
					.equalsIgnoreCase("SINGLE")) {
				throw new CustomErrorException("MerchantLimit", "Limit Does Not Exist For Single Merchant",
						ErrorCodes.RESOURCE_NOT_FOUND.getCode());
			}

			if (mlrepository.findByMerchantID(merchantID) != null) {
				return mlrepository.findByMerchantID(merchantID);
			} else
				throw new ResourceNotFoundException("MerchantLimit", "merchantID", merchantID);
		} else
			throw new ResourceNotFoundException("Merchant", "merchantID", merchantID);
	}

	public List<MerchantTopupLimit> getTransactionByMerchantId(String merchantID) {
		if (!mtlrepository.findByMerchantIDOrderByCreatedAtDesc(merchantID).isEmpty()) {
			return mtlrepository.findByMerchantIDOrderByCreatedAtDesc(merchantID);
		} else
			throw new ResourceNotFoundException("MerchantTopupLimit", "merchantID", merchantID);
	}

}
