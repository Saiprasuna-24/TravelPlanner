package com.test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Travelplanner.Entity.TravelRequests;
import com.Travelplanner.Repo.TravelRequestsRepo;

class TravelRequestsRepoTest {

    @InjectMocks
    private TravelRequestsRepo travelRequestsRepo;

    @Mock
    private TravelRequestsRepo mockTravelRequestsRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByApprovedByHRId() {
        // Create some sample data
        TravelRequests travelRequest1 = new TravelRequests();
        travelRequest1.setApprovedByHRId(1);
        travelRequest1.setRequestRaisedOn(LocalDate.now());
        travelRequest1.setFromDate(new Date());
        travelRequest1.setToDate(new Date());
        travelRequest1.setPurposeOfTravel("Test Purpose 1");
        travelRequest1.setRequestStatus("Pending");
        travelRequest1.setPriority("Low");

        TravelRequests travelRequest2 = new TravelRequests();
        travelRequest2.setApprovedByHRId(1);
        travelRequest2.setRequestRaisedOn(LocalDate.now());
        travelRequest2.setFromDate(new Date());
        travelRequest2.setToDate(new Date());
        travelRequest2.setPurposeOfTravel("Test Purpose 2");
        travelRequest2.setRequestStatus("Approved");
        travelRequest2.setPriority("High");

        List<TravelRequests> travelRequestsList = new ArrayList<>();
        travelRequestsList.add(travelRequest1);
        travelRequestsList.add(travelRequest2);

        // Configure mock behavior
        when(mockTravelRequestsRepo.findByApprovedByHRId(1)).thenReturn(travelRequestsList);

        // Test the method
        List<TravelRequests> foundTravelRequestsList = travelRequestsRepo.findByApprovedByHRId(1);

        // Verify the results
        assertThat(foundTravelRequestsList).isEqualTo(travelRequestsList);
    }
}
