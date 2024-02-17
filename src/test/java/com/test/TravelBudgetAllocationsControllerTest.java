package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.Travelplanner.Controller.TravelBudgetAllocationsController;
import com.Travelplanner.Entity.TravelBudgetAllocations;
import com.Travelplanner.Service.TravelBudgetAllocationsService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
public class TravelBudgetAllocationsControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TravelBudgetAllocationsService travelBudgetAllocationsService;

    @InjectMocks
    private TravelBudgetAllocationsController travelBudgetAllocationsController;

    private TravelBudgetAllocations travelBudgetAllocations;

    private ObjectMapper objectMapper = new ObjectMapper();

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(travelBudgetAllocationsController).build();
        travelBudgetAllocations = new TravelBudgetAllocations();
        
    }

    @Test
    public void testCalculateBudget() throws Exception {
        when(travelBudgetAllocationsService.calculatebudget(travelBudgetAllocations)).thenReturn(travelBudgetAllocations);
        String requestBody = objectMapper.writeValueAsString(travelBudgetAllocations);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/travelrequests/calculatebudget")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andReturn();
        int statusCode = result.getResponse().getStatus();
        String responseContent = result.getResponse().getContentAsString();
        TravelBudgetAllocations responseEntity = objectMapper.readValue(responseContent, TravelBudgetAllocations.class);
        assertEquals(200, statusCode);
        assertEquals(travelBudgetAllocations, responseEntity);
    }
}
