package com.Travelplanner.Dto;

import lombok.Data;

@Data
public class TravelBudgetDto {

	private int Id;

	private int TravelRequestId;

	private int ApprovedBudget;

	private String ApprovedModeOfTravel;

	private String ApprovedHotelStarRating;
}
