package com.Travelplanner.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Travelplanner.Entity.TravelBudgetAllocations;
import com.Travelplanner.Service.TravelBudgetAllocationsService;


@RestController
@CrossOrigin(origins = "*")

public class TravelBudgetAllocationsController {

	@Autowired
	private TravelBudgetAllocationsService travelBudgetAllocationsService;

	@PostMapping("/api/travelrequests/calculatebudget")
	public TravelBudgetAllocations calculatebudget(@RequestBody TravelBudgetAllocations travelBudgetAllocations) {
		return travelBudgetAllocationsService.calculatebudget(travelBudgetAllocations);
	}

}
