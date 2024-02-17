package com.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Travelplanner.Entity.Locations;
import com.Travelplanner.Repo.LocationsRepo;
import com.Travelplanner.Service.LocationsService;

public class LocationsServiceTest {
	
	private LocationsService locationsService;
	private LocationsRepo locationsRepoMock;

	@BeforeEach
	public void setUp() {
		locationsRepoMock = mock(LocationsRepo.class);
		locationsService = new LocationsService();
	//	locationsService.setLocationsRepo(locationsRepoMock);
	}

	@Test
	public void testGetAllLocations() {
		// create some mock data
		Locations loc1 = new Locations(1, "New York");
		Locations loc2 = new Locations(2, "San Francisco");
		List<Locations> locationsList = new ArrayList<>();
		locationsList.add(loc1);
		locationsList.add(loc2);

		// set up mock behavior
		when(locationsRepoMock.findAll()).thenReturn(locationsList);

		// call the service method
		List<Locations> result = locationsService.getAll();

		// assert the result
		assertThat(result).hasSize(2);
		assertThat(result.get(0).getLocationId()).isEqualTo(1);
		assertThat(result.get(0).getName()).isEqualTo("New York");
		assertThat(result.get(1).getLocationId()).isEqualTo(2);
		assertThat(result.get(1).getName()).isEqualTo("San Francisco");
	}

}
