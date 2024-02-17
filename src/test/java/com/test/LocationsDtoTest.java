package com.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Travelplanner.Dto.LocationsDto;

public class LocationsDtoTest {

    @Mock
    private int locationId;

    @Mock
    private String name;

    @InjectMocks
    private LocationsDto locationsDto;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        locationsDto.setLocationId(1);
        locationsDto.setName("New York");
    }

    @Test
    public void testGetLocationId() {
        assertEquals(1, locationsDto.getLocationId());
    }

    @Test
    public void testGetName() {
        assertEquals("New York", locationsDto.getName());
    }

}

