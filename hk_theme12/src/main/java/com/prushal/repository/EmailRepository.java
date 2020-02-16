package com.prushal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prushal.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

}
