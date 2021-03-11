package com.example.project1qa;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import com.example.project1qa.domain.Gig;

import com.fasterxml.jackson.databind.ObjectMapper;


	
	@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	
	@AutoConfigureMockMvc

	@Sql(scripts = {"classpath:gig-schema.sql", "classpath:gig-data.sql" },
	executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	
	@ActiveProfiles("test")


	public class GigControllerIntegrationTest {
		@Autowired
		private MockMvc mockMVC;
		
		@Autowired
		private ObjectMapper mapper;
		
		List <Gig> Gig = new ArrayList<>();
		
		@Test
		void testCreate() throws Exception{
			//creates a gig
			Gig newGig = new Gig("1975", "Bristol", "The Fleece", "2021/04/19", 7);
			
			String newGigAsJSON = this.mapper.writeValueAsString(newGig);
			
			RequestBuilder mockRequest = post("/createGig").contentType(MediaType.APPLICATION_JSON)
					.content(newGigAsJSON);
			
			
			//creates saved gigs
			Gig savedGig = new Gig(1L, "1975", "Bristol", "The Fleece", "2021/04/19", 7);
			String savedGigAsJSON = this.mapper.writeValueAsString(savedGig);
			
			
			ResultMatcher matchStatus = status().isCreated();
			ResultMatcher matchBody = content().json(savedGigAsJSON);
			
			this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
		}
		
		

		//read test
		@Test
		void readTest() throws Exception{
			Gig testGig = new Gig(1L, "1975", "Bristol", "The Fleece", "2021/04/19", 7);
			Gig.add(testGig);
			
			String testGigAsJSON = this.mapper.writeValueAsString(Gig);
			
			RequestBuilder mockRequest = get("/getAllGigs");
			
			ResultMatcher checkStatus = status().isOk();
			ResultMatcher checkBody = content().json(testGigAsJSON);
			
			this.mockMVC.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);
		}
		
		//Making an update test//
			@Test
			void updateTest() throws Exception{
				
						Gig newGig = new Gig("1975", "Bristol", "The Fleece", "2021/04/19", 7);
						
						//convert it to a json string
						String newGigAsJSON = this.mapper.writeValueAsString(newGig);
						
						
						//build mock request
						RequestBuilder mockRequest = put("/update/1").contentType(MediaType.APPLICATION_JSON)
								.content(newGigAsJSON);
						
						
						
						Gig savedGig = new Gig(1L, "1975", "Bristol", "The Fleece", "2021/04/19", 7);
						
						String savedGigAsJSON = this.mapper.writeValueAsString(savedGig);
						
						//check status
						ResultMatcher matchStatus = status().isOk();
						
						ResultMatcher matchBody = content().json(savedGigAsJSON);
						
						this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);	
				
			}
			
			
			
			
			
			//Making a delete test //
			@Test 
			void deleteTest() throws Exception{
				RequestBuilder mockRequest = delete("/delte/2");
				
				ResultMatcher matchStatus = status().isNotFound(); //make sure the status code you get back 
				//matches
				
				this.mockMVC.perform(mockRequest).andExpect(matchStatus);
				
				
						
			}

	}




