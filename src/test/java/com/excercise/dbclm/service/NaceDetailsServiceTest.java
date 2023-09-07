package com.excercise.dbclm.service;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.excercise.dbclm.entity.NaceDetails;
import com.excercise.dbclm.repository.NaceDetailsRepository;

@ExtendWith(MockitoExtension.class)
@DisplayName("Nace details service related test cases")
public class NaceDetailsServiceTest {

	@InjectMocks
	private NaceDetailsService naceDetailsService;
	
	@Mock
	NaceDetailsRepository naceDetailsRepositoty;
	
	private NaceDetails naceDetails;
	
	@BeforeEach
	void init() {
		naceDetails = new NaceDetails();
		naceDetails.setOrderId("39843");
		naceDetails.setLevel("1");
		naceDetails.setCode("A");
		naceDetails.setParent("");
		naceDetails.setDescription("some description");
		naceDetails.setThisItemIncludes("some items includes");
		naceDetails.setThisItemAlsoIncludes("some item also includes");
		naceDetails.setRuling("");
		naceDetails.setThisItemExcludes("some item excludes");
		naceDetails.setReferenceToISICRev4("A");
	}
	
	@Test
	@DisplayName("create nace details")
	public void createNaceDetails() {
		when(naceDetailsRepositoty.save(any())).thenReturn(naceDetails);
		Assertions.assertEquals("39843",naceDetailsService.createNaceDetails(new NaceDetails()).getOrderId());
	}
	
	@Test
	@DisplayName("get nace details")
	public void getNaceDetails() {
		when(naceDetailsRepositoty.findByOrderId(any())).thenReturn(naceDetails);
		Assertions.assertEquals("39843",naceDetailsService.getNaceDetails("39843").getOrderId());
	}
}
