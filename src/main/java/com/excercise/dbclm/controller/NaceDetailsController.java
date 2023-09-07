package com.excercise.dbclm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.excercise.dbclm.service.NaceDetailsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.excercise.dbclm.entity.NaceDetails;

@Api(tags = {"nace details controller"})
@RestController
@RequestMapping("/nacedetails")
public class NaceDetailsController {
	
	@Autowired
	private NaceDetailsService naceDetailsService;
	
	@ApiOperation(value = "This will create nace details")
	@PostMapping
	public ResponseEntity<NaceDetails> createNaceDetails(@RequestBody NaceDetails naceDetails) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(naceDetailsService.createNaceDetails(naceDetails));

	}
	
	@ApiOperation(value = "This will fetch the nace details by orderId")
	@GetMapping("/{order}")
	public ResponseEntity<NaceDetails> getNaceDetails(@PathVariable String order) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(naceDetailsService.getNaceDetails(order));
	}

}
