package com.Travelplanner.Entity;

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
public class Locations {

	public Locations(String string, String string2) {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int locationId;

	//@ManyToOne(fetch=FetchType.LAZY)
    //@JoinColumn
	//private TravelRequests travelRequests;
	
	@Column(name = "Name", length = 20)
	private String name;

	

}
