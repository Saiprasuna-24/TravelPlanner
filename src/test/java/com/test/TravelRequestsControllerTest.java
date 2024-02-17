/*
package com.test;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.Travelplanner.Controller.TravelRequestsController;
import com.Travelplanner.Dto.TravelRequestsDto;
import com.Travelplanner.Service.TravelRequestsService;

@SpringJUnitConfig
@WebMvcTest(TravelRequestsController.class)
public class TravelRequestsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TravelRequestsService travelRequestsService;

    @InjectMocks
    private TravelRequestsController travelRequestsController;

    @Test
    public void testCreateArequest() throws Exception {
        // Arrange
        TravelRequestsDto travelRequestsDto = new TravelRequestsDto();
        travelRequestsDto.setRequestId(1);
        travelRequestsDto.setRaisedByEmployeeId(101);
        travelRequestsDto.setFromDate(2023/05/01);
        travelRequestsDto.setToDate("2023-05-10");
        travelRequestsDto.setPurposeOfTravel("Business");

        doNothing().when(travelRequestsService).createArequest(any(TravelRequestsDto.class));

        // Act
        ResultActions resultActions = mockMvc.perform(post("/api/travelrequests/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"id\": 1, \"RaisedByEmployeeId\": 101, \"destination\": \"New York\", \"travelStartDate\": \"2023-05-01\", \"travelEndDate\": \"2023-05-10\", \"purposeOfTravel\": \"Business\" }")
        );

        // Assert
        resultActions
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("New travel request has been created."));
    }

    @Test
    public void testGetByApprovedByHRId() throws Exception {
        // Arrange
        TravelRequestsDto travelRequestsDto1 = new TravelRequestsDto();
        travelRequestsDto1.setId(1);
        travelRequestsDto1.setEmployeeId(101);
        travelRequestsDto1.setDestination("New York");
        travelRequestsDto1.setTravelStartDate("2023-05-01");
        travelRequestsDto1.setTravelEndDate("2023-05-10");
        travelRequestsDto1.setPurposeOfTravel("Business");
        travelRequestsDto1.setApprovedByHRId(201);

        TravelRequestsDto travelRequestsDto2 = new TravelRequestsDto();
        travelRequestsDto2.setId(2);
        travelRequestsDto2.setEmployeeId(102);
        travelRequestsDto2.setDestination("London");
        travelRequestsDto2.setTravelStartDate("2023-06-01");
        travelRequestsDto2.setTravelEndDate("2023-06-10");
        travelRequestsDto2.setPurposeOfTravel("Vacation");
        travelRequestsDto2.setApproved'
    }
    
*/

package com.test;


import com.Travelplanner.Controller.TravelRequestsController;
import com.Travelplanner.Dto.TravelRequestsDto;
import com.Travelplanner.Service.TravelRequestsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class TravelRequestsControllerTest {

    private TravelRequestsController travelRequestsController;

    @Mock
    private TravelRequestsService travelRequestsService;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        travelRequestsController = new TravelRequestsController();
        travelRequestsController.travelRequestsService = travelRequestsService;
    }

    @Test
    public void testCreateRequest() throws Exception {
        TravelRequestsDto travelRequestsDto = new TravelRequestsDto();
        ResponseEntity<String> expectedResponse = ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"message\": \"New travel request has been created.\"}");

        doNothing().when(travelRequestsService).createArequest(any(TravelRequestsDto.class));

        ResponseEntity<?> actualResponse = travelRequestsController.add(travelRequestsDto);

        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getHeaders(), actualResponse.getHeaders());
        assertEquals(expectedResponse.getBody(), actualResponse.getBody());
        verify(travelRequestsService, times(1)).createArequest(any(TravelRequestsDto.class));
    }

    @Test
    public void testGetByApprovedByHRId() {
        int approvedByHRId = 1;
        List<TravelRequestsDto> expectedTravelRequests = Collections.singletonList(new TravelRequestsDto());

        when(travelRequestsService.getByApprovedByHRId(anyInt())).thenReturn(expectedTravelRequests);

        ResponseEntity<List<TravelRequestsDto>> actualResponse = travelRequestsController.getByApprovedByHRId(approvedByHRId);

        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(expectedTravelRequests, actualResponse.getBody());
        verify(travelRequestsService, times(1)).getByApprovedByHRId(anyInt());
    }

    @Test
    public void testGetById() {
        int requestId = 1;
        TravelRequestsDto expectedTravelRequest = new TravelRequestsDto();

        when(travelRequestsService.getById(anyInt())).thenReturn(expectedTravelRequest);

        ResponseEntity<TravelRequestsDto> actualResponse = travelRequestsController.getById(requestId);

        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(expectedTravelRequest, actualResponse.getBody());
        verify(travelRequestsService, times(1)).getById(anyInt());
    }

    @Test
    public void testProcess() {
        int requestId = 1;
        TravelRequestsDto travelRequestsDto = new TravelRequestsDto();
        ResponseEntity<String> expectedResponse = ResponseEntity.ok("{\"message\": \"Travel request status updated for RequestId: " + requestId + "\"}");

        doNothing().when(travelRequestsService).process(anyInt(), any(TravelRequestsDto.class));

        ResponseEntity<String> actualResponse = travelRequestsController.process(requestId, travelRequestsDto);

        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getHeaders(), actualResponse.getHeaders());
        assertEquals(expectedResponse.getBody(), actualResponse.getBody());
        verify(travelRequestsService, times(1)).process(anyInt(), any(TravelRequestsDto.class));
    }

}

