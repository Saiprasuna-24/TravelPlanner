package com.Travelplanner.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Travelplanner.Dto.TravelRequestsDto;
import com.Travelplanner.Service.TravelRequestsService;

@RestController
@CrossOrigin(origins = "*")

public class TravelRequestsController {

	@Autowired
	public TravelRequestsService travelRequestsService;

	@PostMapping(value = "/api/travelrequests/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add(@RequestBody TravelRequestsDto travelRequestsDto) throws Exception {
        // Call the service to create a travel request
		travelRequestsService.createArequest(travelRequestsDto);

        // Create a response JSON object with the message
        String message = "New travel request has been created.";
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"message\": \"" + message + "\"}");
    }
	
	//To view all the records
	@GetMapping("/api/travelrequests/requests")
	public ResponseEntity<List<TravelRequestsDto>> getAllRequests() {
		List<TravelRequestsDto> travelRequests = travelRequestsService.getAllRequests();
	    return ResponseEntity.ok(travelRequests);
	}

	@GetMapping("/api/travelrequests/{approvedByHRId}/pending")
	public ResponseEntity<List<TravelRequestsDto>> getByApprovedByHRId(@PathVariable Integer approvedByHRId) {
        List<TravelRequestsDto> travelRequests = travelRequestsService.getByApprovedByHRId(approvedByHRId);
        return ResponseEntity.ok(travelRequests);
    }


	@GetMapping("/api/travelrequests/{RequestId}")
    public ResponseEntity<TravelRequestsDto> getById(@PathVariable Integer RequestId){
        return new ResponseEntity<>(travelRequestsService.getById(RequestId),HttpStatus.OK);
    }

	@PutMapping("/api/travelrequests/{RequestId}/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> process(@PathVariable(name = "RequestId") Integer RequestId,
                                          @RequestBody TravelRequestsDto TravelRequestsDto1 ) {
		travelRequestsService.process(RequestId, TravelRequestsDto1);

        // Create a response JSON object with the updated status message
        String message = "Travel request status updated for RequestId: " + RequestId;
        return ResponseEntity.ok("{\"message\": \"" + message + "\"}");
    }


}
