package com.Travelplanner.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Travelplanner.Entity.TravelBudgetAllocations;
import com.Travelplanner.Repo.TravelBudgetAllocationsRepo;


@Service
public class TravelBudgetAllocationsService {

	  @Autowired
	  private TravelBudgetAllocationsRepo travelBudgetAllocationsRepo;

	  public TravelBudgetAllocations calculatebudget(TravelBudgetAllocations travelBudgetAllocations) {
			return travelBudgetAllocationsRepo.save(travelBudgetAllocations);
		}


}
