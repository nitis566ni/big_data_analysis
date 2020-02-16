package com.prushal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prushal.model.MerchantReduceLimit;

public interface MerchantReduceLimitRepository extends JpaRepository<MerchantReduceLimit, Long> {

	List<MerchantReduceLimit> findByMerchantIDOrderByCreatedAtDesc(String merchantID);

	MerchantReduceLimit findLastByMerchantID(String merchantID);
}
