package com.prushal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prushal.model.NotificationHistory;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationHistory, Long> {

	List<NotificationHistory> findByCustomerID(String customerID); 
	
	List<NotificationHistory> findByMerchantID(String merchantID);
	
}
