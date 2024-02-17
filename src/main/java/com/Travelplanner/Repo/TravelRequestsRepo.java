package com.Travelplanner.Repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Travelplanner.Entity.TravelRequests;

@Repository
public interface TravelRequestsRepo extends JpaRepository<TravelRequests, Integer> {

	List<TravelRequests> findByApprovedByHRId(Integer approvedByHRId);


}
