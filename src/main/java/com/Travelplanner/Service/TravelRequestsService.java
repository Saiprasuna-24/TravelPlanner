package com.Travelplanner.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Travelplanner.Dto.TravelRequestsDto;
import com.Travelplanner.Entity.TravelRequests;
import com.Travelplanner.Repo.TravelRequestsRepo;
import com.Travelplanner.exception.ResourceNotfoundException;

@Service
public class TravelRequestsService {

	@Autowired
	private TravelRequestsRepo travelRequestsRepo;
	
	@Autowired
    ModelMapper modelMapper;


	public void createArequest(TravelRequestsDto travelRequestsDto){
		TravelRequests travelRequest= modelMapper.map(travelRequestsDto,TravelRequests.class);
		travelRequestsRepo.save(travelRequest);
    }
	
	//all request    
    public List<TravelRequestsDto> getAllRequests() {
        List<TravelRequests> travelRequests = travelRequestsRepo.findAll();
        List<TravelRequestsDto> TravelRequestsDtos = new ArrayList<>();
        for (TravelRequests travelRequest : travelRequests) {
        	TravelRequestsDto TravelRequestsDto = modelMapper.map(travelRequest, TravelRequestsDto.class);
        	TravelRequestsDtos.add(TravelRequestsDto);
        }
        return TravelRequestsDtos;
    }
    
    
	public List<TravelRequestsDto> getByApprovedByHRId(Integer approvedByHRId) {
        List<TravelRequests> travelRequests = travelRequestsRepo.findByApprovedByHRId(approvedByHRId);
        return travelRequests.stream()
                .map(travelRequest -> modelMapper.map(travelRequest, TravelRequestsDto.class))
                .collect(Collectors.toList());
    }



   public TravelRequestsDto getById(Integer RequestId){
	   TravelRequests travelRequest=travelRequestsRepo.findById(RequestId).orElseThrow(()-> new  ResourceNotfoundException("Category",RequestId,"RequestID"));
        return modelMapper.map(travelRequest,TravelRequestsDto.class);
    }
   
   
   public void process(Integer RequestId, TravelRequestsDto TravelRequestsDto1) throws RuntimeException {
	   TravelRequests travelRequests=travelRequestsRepo.findById(RequestId).orElseThrow(()-> new  ResourceNotfoundException("Category",RequestId,"RequestID"));
           
	   travelRequests.setStatus(TravelRequestsDto1.getStatus());

	   travelRequestsRepo.save(travelRequests); 
   
   }

   

}
