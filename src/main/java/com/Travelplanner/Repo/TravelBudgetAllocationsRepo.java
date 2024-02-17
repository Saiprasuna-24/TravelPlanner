package com.Travelplanner.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Travelplanner.Entity.TravelBudgetAllocations;

@Repository
public interface TravelBudgetAllocationsRepo extends JpaRepository<TravelBudgetAllocations, Integer> {

}
