package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.Travelplanner.Dto.TravelRequestsDto;

import org.junit.jupiter.api.BeforeEach;

import java.util.Date;


public class TravelRequestsDtoTest {

    private TravelRequestsDto travelRequestsDto;

    @BeforeEach
    public void setUp() {
        travelRequestsDto = mock(TravelRequestsDto.class);
        when(travelRequestsDto.getRequestId()).thenReturn(1);
        when(travelRequestsDto.getRaisedByEmployeeId()).thenReturn(100);
        when(travelRequestsDto.getApprovedByHRId()).thenReturn(200);
        when(travelRequestsDto.getFromDate()).thenReturn(new Date());
        when(travelRequestsDto.getToDate()).thenReturn(new Date());
        when(travelRequestsDto.getPurposeOfTravel()).thenReturn("Business Trip");
        when(travelRequestsDto.getRequestStatus()).thenReturn("Approved");
        when(travelRequestsDto.getPriority()).thenReturn("High");
    }

    @Test
    public void testGetRequestId() {
        assertEquals(1, travelRequestsDto.getRequestId());
    }

    @Test
    public void testGetRaisedByEmployeeId() {
        assertEquals(100, travelRequestsDto.getRaisedByEmployeeId().intValue());
    }

    @Test
    public void testGetApprovedByHRId() {
        assertEquals(200, travelRequestsDto.getApprovedByHRId());
    }

    @Test
    public void testGetFromDate() {
        assertNotNull(travelRequestsDto.getFromDate());
    }

    @Test
    public void testGetToDate() {
        assertNotNull(travelRequestsDto.getToDate());
    }

    @Test
    public void testGetPurposeOfTravel() {
        assertEquals("Business Trip", travelRequestsDto.getPurposeOfTravel());
    }

    @Test
    public void testGetRequestStatus() {
        assertEquals("Approved", travelRequestsDto.getRequestStatus());
    }

    @Test
    public void testGetPriority() {
        assertEquals("High", travelRequestsDto.getPriority());
    }
}
