package com.prushal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prushal.model.LoginPageInfo;

@Repository
public interface LoginPageInfoRepository extends JpaRepository<LoginPageInfo, Long> {

}
