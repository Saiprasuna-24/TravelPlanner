package com.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.Travelplanner.Entity.TravelBudgetAllocations;
import com.Travelplanner.Repo.TravelBudgetAllocationsRepo;
import com.Travelplanner.Service.TravelBudgetAllocationsService;

@SpringBootTest
public class TravelBudgetAllocationsServiceTest {

    @InjectMocks
    private TravelBudgetAllocationsService travelBudgetAllocationsService;

    @Mock
    private TravelBudgetAllocationsRepo travelBudgetAllocationsRepo;

    @Test
    public void testCalculateBudget() {
        // create a TravelBudgetAllocations object
        TravelBudgetAllocations tba = new TravelBudgetAllocations();
        tba.setTravelRequestId(1);
        tba.setApprovedBudget(1000);
        tba.setApprovedModeOfTravel("Flight");
        tba.setApprovedHotelStarRating("3");

        // mock the behavior of the travelBudgetAllocationsRepo.save() method
        when(travelBudgetAllocationsRepo.save(tba)).thenReturn(tba);

        // call the calculate budget() method of the service
        TravelBudgetAllocations result = travelBudgetAllocationsService.calculatebudget(tba);

        // verify that the travelBudgetAllocationsRepo.save() method was called exactly once with the correct argument
        verify(travelBudgetAllocationsRepo, times(1)).save(tba);

        // verify that the returned object is the same as the input object
        assertEquals(tba, result);
    }
}
