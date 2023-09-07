package com.excercise.dbclm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excercise.dbclm.entity.NaceDetails;
import com.excercise.dbclm.repository.NaceDetailsRepository;

@Service
public class NaceDetailsService {
	
	@Autowired
	NaceDetailsRepository naceDetailsRepositoty;
	
	
	public NaceDetails createNaceDetails(NaceDetails naceDetails) {
		System.out.print("Entered createNaceDetails service method");
		NaceDetails outNaceDetails = naceDetailsRepositoty.save(naceDetails);
		return outNaceDetails;
	}
	
	public NaceDetails getNaceDetails(String order) {
		System.out.print("Entered getNaceDetails service method");
		NaceDetails outNaceDetails =naceDetailsRepositoty.findByOrderId(order);
		return outNaceDetails;
	}

}
