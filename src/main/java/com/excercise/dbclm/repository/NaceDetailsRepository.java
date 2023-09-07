package com.excercise.dbclm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excercise.dbclm.entity.NaceDetails;

@Repository
public interface NaceDetailsRepository extends JpaRepository<NaceDetails, String>{

	NaceDetails findByOrderId(String orderId);
}
