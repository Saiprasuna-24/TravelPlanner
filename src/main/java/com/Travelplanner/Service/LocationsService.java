package com.Travelplanner.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Travelplanner.Entity.Locations;
import com.Travelplanner.Repo.LocationsRepo;

@Service
public class LocationsService {

	@Autowired
	private LocationsRepo locationsRepo;

	public List<Locations> getAll() {
		return locationsRepo.findAll();
	}

}
