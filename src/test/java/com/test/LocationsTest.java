package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Travelplanner.Entity.Locations;
import com.Travelplanner.Entity.TravelRequests;

@ExtendWith(MockitoExtension.class)
public class LocationsTest {

    @Mock
    private TravelRequests travelRequests;

    @InjectMocks
    private Locations locations;

    @BeforeEach
    public void setUp() {
        locations = new Locations("locationName", "locationAddress");
    }

    @Test
    public void testGetLocationId() {
        locations.setLocationId(1);
        Assertions.assertEquals(1, locations.getLocationId());
    }

   // @Test
   // public void testGetName() {
   //     Assertions.assertEquals("locationName", locations.getName());
   // }

    @Test
    public void testSetName() {
        locations.setName("newLocationName");
        Assertions.assertEquals("newLocationName", locations.getName());
    }

    @Test
    public void testToString() {
        String expected = "Locations(locationId=0, name=locationName)";
        Assertions.assertEquals(expected, locations.toString());
    }
}
