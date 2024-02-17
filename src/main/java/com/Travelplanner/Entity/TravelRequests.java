package com.Travelplanner.Entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class TravelRequests {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer RequestId;

	private Integer RaisedByEmployeeId;

	private Integer approvedByHRId;

	public LocalDate RequestRaisedOn=LocalDate.now();

	private Date FromDate;

	private Date ToDate;

	@Column(name = "PurposeOfTravel", length = 100)
	private String PurposeOfTravel;
	

	@Column(name = "RequestStatus", length = 15)
	private String RequestStatus;
	
	private String Status;


	private LocalDate RequestApprovedOn=LocalDate.now();

	@Column(name = "Priority")
	private String Priority;

}
