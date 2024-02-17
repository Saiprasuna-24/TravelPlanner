package com.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Travelplanner.Controller.LocationsController;
import com.Travelplanner.Entity.Locations;
import com.Travelplanner.Service.LocationsService;

import static org.mockito.Mockito.*;

public class LocationsControllerTest {

    @Mock
    private LocationsService locationsService;

    @InjectMocks
    private LocationsController locationsController;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllLocations() {
        List<Locations> locationsList = new ArrayList<>();
        Locations location1 = new Locations("Tokyo", "Japan");
        Locations location2 = new Locations("New York", "USA");
        locationsList.add(location1);
        locationsList.add(location2);

        when(locationsService.getAll()).thenReturn(locationsList);

        ResponseEntity<List<Locations>> responseEntity = locationsController.getAll();

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(locationsList, responseEntity.getBody());

        verify(locationsService, times(1)).getAll();
        verifyNoMoreInteractions(locationsService);
    }
}
