package com.excercise.dbclm.integrationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import com.excercise.dbclm.entity.NaceDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Nace details inegration test")
public class NaceDetailsIntegrationTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	TestNaceDetailsRepositoty testNaceDetailsRepositoty;
	
	private String baseUrl = "http://localhost";
	
	private static final String insertQuery = "insert into nace_details(order_id,code,description,level,parent,reference_to_isic_rev4,ruling,this_item_also_includes,this_item_excludes,this_item_includes) values ('398485','1.12','Growing of rice','4','1.1','112','','','','this_item_includes')";
	private static final String deleteQuery = "delete from nace_details where order_id = '398485'";
	
	private static RestTemplate restTempate;
	
	@BeforeAll
	public static void init() {
		restTempate = new RestTemplate();
	}
	
	@BeforeEach
	public void setUp() {
		baseUrl = baseUrl.concat(":").concat(port+"").concat("/nacedetails");
	}
	
	@Test
	@Sql(statements = "delete from nace_details where order_id in ('398481','398482','398483','398484','398485')",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	public void createNaceDetails() throws JsonMappingException, JsonProcessingException {
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
		NaceDetails response = restTempate.postForObject(baseUrl, details, NaceDetails.class);
		assertEquals("1234", response.getOrderId());
		assertEquals(1, testNaceDetailsRepositoty.findAll().size());
	}
	
	
	@Test
	@Sql(statements = insertQuery, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = deleteQuery, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void getNaceDetails() {
		NaceDetails details = restTempate.getForObject(baseUrl.concat("/398485"), NaceDetails.class);
		assertEquals("398485", details.getOrderId());
		assertEquals(2, testNaceDetailsRepositoty.findAll().size());
	}
	
	
}
