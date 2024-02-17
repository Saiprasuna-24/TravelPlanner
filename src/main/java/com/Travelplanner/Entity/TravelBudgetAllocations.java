package com.Travelplanner.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class TravelBudgetAllocations {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	private int TravelRequestId;

	private int ApprovedBudget;

	@Column(name = "ApprovedModeOfTravel", length = 10)
	private String ApprovedModeOfTravel;

	@Column(name = "ApprovedHotelStarRating", length = 6)
	private String ApprovedHotelStarRating;


}
