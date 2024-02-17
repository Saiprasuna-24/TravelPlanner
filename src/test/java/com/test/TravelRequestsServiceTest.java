package com.test;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.Travelplanner.Dto.TravelRequestsDto;
import com.Travelplanner.Entity.TravelRequests;
import com.Travelplanner.Repo.TravelRequestsRepo;
import com.Travelplanner.Service.TravelRequestsService;

import static org.junit.jupiter.api.Assertions.*;

public class TravelRequestsServiceTest {
	
	@InjectMocks
	private TravelRequestsService travelRequestsService;
	
	@Mock
	private TravelRequestsRepo travelRequestsRepo;
	
	@Mock
    ModelMapper modelMapper;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCreateArequest() {
		TravelRequestsDto travelRequestsDto = new TravelRequestsDto();
		TravelRequests travelRequest = new TravelRequests();
		when(modelMapper.map(travelRequestsDto, TravelRequests.class)).thenReturn(travelRequest);
		travelRequestsService.createArequest(travelRequestsDto);
		verify(travelRequestsRepo, times(1)).save(travelRequest);
	}

	@Test
	void testGetAllRequests() {
		List<TravelRequests> travelRequests = Arrays.asList(new TravelRequests(), new TravelRequests());
		List<TravelRequestsDto> travelRequestsDtos = Arrays.asList(new TravelRequestsDto(), new TravelRequestsDto());
		when(travelRequestsRepo.findAll()).thenReturn(travelRequests);
		when(modelMapper.map(any(TravelRequests.class), eq(TravelRequestsDto.class))).thenReturn(new TravelRequestsDto());
		List<TravelRequestsDto> result = travelRequestsService.getAllRequests();
		assertEquals(travelRequestsDtos.size(), result.size());
	}

	@Test
	void testGetByApprovedByHRId() {
		List<TravelRequests> travelRequests = Arrays.asList(new TravelRequests(), new TravelRequests());
		List<TravelRequestsDto> travelRequestsDtos = Arrays.asList(new TravelRequestsDto(), new TravelRequestsDto());
		Integer approvedByHRId = 1;
		when(travelRequestsRepo.findByApprovedByHRId(approvedByHRId)).thenReturn(travelRequests);
		when(modelMapper.map(any(TravelRequests.class), eq(TravelRequestsDto.class))).thenReturn(new TravelRequestsDto());
		List<TravelRequestsDto> result = travelRequestsService.getByApprovedByHRId(approvedByHRId);
		assertEquals(travelRequestsDtos.size(), result.size());
	}

	@Test
	void testGetById() {
		Integer requestId = 1;
		TravelRequests travelRequest = new TravelRequests();
		TravelRequestsDto travelRequestDto = new TravelRequestsDto();
		when(travelRequestsRepo.findById(requestId)).thenReturn(java.util.Optional.of(travelRequest));
		when(modelMapper.map(travelRequest, TravelRequestsDto.class)).thenReturn(travelRequestDto);
		TravelRequestsDto result = travelRequestsService.getById(requestId);
		assertNotNull(result);
	}

	@Test
	void testProcess() {
		Integer requestId = 1;
		TravelRequestsDto travelRequestsDto = new TravelRequestsDto();
		travelRequestsDto.setRequestStatus("approved");
		TravelRequests travelRequest = new TravelRequests();
		when(travelRequestsRepo.findById(requestId)).thenReturn(java.util.Optional.of(travelRequest));
		travelRequestsService.process(requestId, travelRequestsDto);
		verify(travelRequestsRepo, times(1)).save(travelRequest);
	}
}