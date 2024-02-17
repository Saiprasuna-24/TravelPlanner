package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import com.Travelplanner.Dto.TravelBudgetDto;

public class TravelBudgetDtoTest {

    private TravelBudgetDto travelBudgetDto;

    @BeforeEach
    public void setUp() {
        travelBudgetDto = mock(TravelBudgetDto.class);
        when(travelBudgetDto.getId()).thenReturn(1);
        when(travelBudgetDto.getTravelRequestId()).thenReturn(2);
        when(travelBudgetDto.getApprovedBudget()).thenReturn(5000);
        when(travelBudgetDto.getApprovedModeOfTravel()).thenReturn("Flight");
        when(travelBudgetDto.getApprovedHotelStarRating()).thenReturn("3 Star");
    }

    @Test
    public void testGetId() {
        assertEquals(1, travelBudgetDto.getId());
    }

    @Test
    public void testGetTravelRequestId() {
        assertEquals(2, travelBudgetDto.getTravelRequestId());
    }

    @Test
    public void testGetApprovedBudget() {
        assertEquals(5000, travelBudgetDto.getApprovedBudget());
    }

    @Test
    public void testGetApprovedModeOfTravel() {
        assertEquals("Flight", travelBudgetDto.getApprovedModeOfTravel());
    }

    @Test
    public void testGetApprovedHotelStarRating() {
        assertEquals("3 Star", travelBudgetDto.getApprovedHotelStarRating());
    }
}

