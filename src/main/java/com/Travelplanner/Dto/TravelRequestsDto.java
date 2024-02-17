package com.Travelplanner.Dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class TravelRequestsDto {

	private int RequestId;

	private Integer RaisedByEmployeeId;

	private Integer ApprovedByHRId;

	public LocalDate RequestRaisedOn=LocalDate.now();

	private Date FromDate;

	private Date ToDate;

	private String PurposeOfTravel;

	private String RequestStatus;

	private LocalDate RequestApprovedOn=LocalDate.now();

	private String Priority;


	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
