package com.Travelplanner.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Travelplanner.Entity.Locations;

@Repository
public interface LocationsRepo extends JpaRepository<Locations, Integer> {

}
