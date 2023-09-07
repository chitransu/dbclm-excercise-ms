package com.excercise.dbclm.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.excercise.dbclm.entity.NaceDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@DataJpaTest
@DisplayName("Nace details repository related test cases")
public class NaceDetailsRepositoryTest {
	
	@Autowired
	NaceDetailsRepository naceDetailsRepository;
	
	@Test
	@DisplayName("get nace details")
	public void getNaceDetails() {
		String orderId = naceDetailsRepository.findByOrderId("398481").getOrderId();
		Assertions.assertNotNull(orderId);
		Assertions.assertEquals("398481", orderId);;
	}
	
	@Test
	@DisplayName("create nace details")
	public void createDetails() throws JsonMappingException, JsonProcessingException {
		String jsonRequest = "{\r\n"
				+ "	\"orderId\": \"1234\",\r\n"
				+ "	\"level\": \"1\",\r\n"
				+ "	\"code\": \"A\",\r\n"
				+ "	\"parent\": \" \",\r\n"
				+ "	\"description\": \"Some description\",\r\n"
				+ "	\"thisItemIncludes\": \"This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops,raising and breeding of animals,harvesting of timber and other plants,animals or animal products from a farm or their natural habitats\",\r\n"
				+ "	\"thisItemAlsoIncludes\": \"some more items includes\",\r\n"
				+ "	\"thisItemExcludes\": \"item excludes\",\r\n"
				+ "	\"ruling\": \" \",\r\n"
				+ "	\"referenceToISICRev4\": \"A\"\r\n"
				+ "}";
		ObjectMapper mapper = new ObjectMapper();
		NaceDetails details = mapper.readValue(jsonRequest, NaceDetails.class);
		String orderId = naceDetailsRepository.save(details).getOrderId();
		Assertions.assertNotNull(orderId);
		Assertions.assertEquals("1234", orderId);;
	}
}
