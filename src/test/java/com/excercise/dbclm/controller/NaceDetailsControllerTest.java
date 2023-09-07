package com.excercise.dbclm.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.excercise.dbclm.service.NaceDetailsService;

@WebMvcTest(NaceDetailsController.class)
@DisplayName("Nace details controller related test cases")
public class NaceDetailsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private NaceDetailsService detailsService;
	
	@Test
	@DisplayName("get nace details by orderid")
	void getNaceDetails() throws Exception{
		ResultActions resultActions = this.mockMvc.perform(get("/nacedetails/123"))
			.andDo(print())
			.andExpect(status().isOk());
		System.out.println("Expected Value: "+ 200 + "Actual Value: " + resultActions.andReturn().getResponse().getStatus());
	}
	
	@Test
	@DisplayName("create nace details")
	void createNaceDetails() throws Exception {
		ResultActions resultActions = this.mockMvc.perform(post("/nacedetails")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "	\"orderId\": \"39843\",\r\n"
						+ "	\"level\": \"1\",\r\n"
						+ "	\"code\": \"A\",\r\n"
						+ "	\"parent\": \" \",\r\n"
						+ "	\"description\": \"Some description\",\r\n"
						+ "	\"this_item_includes\": \"some items includes\",\r\n"
						+ "	\"this_item_also_includes\": \"some more items includes\",\r\n"
						+ "	\"ruling\": \" \",\r\n"
						+ "	\"references_to_isic_rev_4\": \"A\"\r\n"
						+ "}")
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print()).andExpect(status().is(201));
		System.out.println("Expected Value: "+ 201 + "Actual Value: " + resultActions.andReturn().getResponse().getStatus());
	}
}
