package com.test;

import org.junit.jupiter.api.Test;

import com.Travelplanner.Entity.TravelRequests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Date;

public class TravelRequestsTest {

    @SuppressWarnings("deprecation")
	@Test
    public void testTravelRequestsEntity() {
        TravelRequests travelRequests = new TravelRequests();
        travelRequests.setRequestId(1);
        travelRequests.setRaisedByEmployeeId(2);
        travelRequests.setApprovedByHRId(3);
        travelRequests.setFromDate(new Date(2023, 04, 30));
        travelRequests.setToDate(new Date(2023, 05, 05));
        travelRequests.setPurposeOfTravel("Business trip");
        travelRequests.setRequestStatus("Pending");
        travelRequests.setStatus("Approved");
        travelRequests.setRequestApprovedOn(LocalDate.of(2023, 05, 01));
        travelRequests.setPriority("High");

        assertEquals(1, travelRequests.getRequestId());
        assertEquals(2, travelRequests.getRaisedByEmployeeId());
        assertEquals(3, travelRequests.getApprovedByHRId());
        assertEquals(new Date(2023, 04, 30), travelRequests.getFromDate());
        assertEquals(new Date(2023, 05, 05), travelRequests.getToDate());
        assertEquals("Business trip", travelRequests.getPurposeOfTravel());
        assertEquals("Pending", travelRequests.getRequestStatus());
        assertEquals("Approved", travelRequests.getStatus());
        assertEquals(LocalDate.of(2023, 05, 01), travelRequests.getRequestApprovedOn());
        assertEquals("High", travelRequests.getPriority());
    }
}
