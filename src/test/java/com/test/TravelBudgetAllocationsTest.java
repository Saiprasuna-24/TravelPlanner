package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.Travelplanner.Entity.TravelBudgetAllocations;
import com.Travelplanner.Entity.TravelRequests;

@SpringBootTest
public class TravelBudgetAllocationsTest {

    @Mock
    private TravelRequests travelRequests;

    @InjectMocks
    private TravelBudgetAllocations travelBudgetAllocations;

    @Test
    public void testSetAndGetId() {
        int id = 1;
        travelBudgetAllocations.setId(id);
        assertEquals(id, travelBudgetAllocations.getId());
    }

    @Test
    public void testSetAndGetTravelRequestId() {
        int requestId = 2;
        travelBudgetAllocations.setTravelRequestId(requestId);
        assertEquals(requestId, travelBudgetAllocations.getTravelRequestId());
    }

    @Test
    public void testSetAndGetApprovedBudget() {
        int budget = 1000;
        travelBudgetAllocations.setApprovedBudget(budget);
        assertEquals(budget, travelBudgetAllocations.getApprovedBudget());
    }

    @Test
    public void testSetAndGetApprovedModeOfTravel() {
        String modeOfTravel = "flight";
        travelBudgetAllocations.setApprovedModeOfTravel(modeOfTravel);
        assertEquals(modeOfTravel, travelBudgetAllocations.getApprovedModeOfTravel());
    }

    @Test
    public void testSetAndGetApprovedHotelStarRating() {
        String hotelStarRating = "4 star";
        travelBudgetAllocations.setApprovedHotelStarRating(hotelStarRating);
        assertEquals(hotelStarRating, travelBudgetAllocations.getApprovedHotelStarRating());
    }
}
