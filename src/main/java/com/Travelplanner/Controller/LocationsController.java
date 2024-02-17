package com.Travelplanner.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Travelplanner.Entity.Locations;
import com.Travelplanner.Service.LocationsService;

@RestController
@CrossOrigin(origins = "*")

public class LocationsController {

	@Autowired
	private LocationsService locationsService;
/*
	private List<Locations> getAll() {
		return locationsService.getAll();
	}
*/
	@GetMapping("/api/travelrequests/locations")
	public ResponseEntity<List<Locations>> getAll() {
        List<Locations> locations = locationsService.getAll();
        return ResponseEntity.ok(locations);
    }

}
