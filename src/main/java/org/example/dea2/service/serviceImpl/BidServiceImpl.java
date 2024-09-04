package org.example.dea2.service.serviceImpl;

import org.example.dea2.repository.BidRepository;
import org.example.dea2.dto.request.BidApiRequest;
import org.example.dea2.dto.response.ApiResponse;
import org.example.dea2.entity.BidEntity;
import org.example.dea2.entity.UserDetailsEntity;
import org.example.dea2.entity.VehicleEntity;
import org.example.dea2.repository.SellingAddRepository;
import org.example.dea2.repository.UserRepository;
import org.example.dea2.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BidServiceImpl implements BidService {
    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SellingAddRepository sellingAddRepository;


    @Override
    public ApiResponse save(BidApiRequest request) {
        ApiResponse response = new ApiResponse();

        try{
            BidEntity bid = new BidEntity();
            bid.setBidAmount(request.getBidAmount());
            bid.setBidDate(new Date());
            bid.setSellingId(request.getSellingId());
            bid.setUserId(request.getUserId());
            bidRepository.save(bid);
            response.setMessage("Success");
            response.setStatus(200);

        }
        catch (Exception e){
            response.setMessage("Error "+e.getMessage());
            response.setStatus(400);

        }



        return response;
    }

    @Override
    public ApiResponse view() {
        ApiResponse response = new ApiResponse();

      try{
          List<BidEntity> bids = bidRepository.findAll();

          List<Integer> userIds = bids.stream()
                  .map(BidEntity::getUserId)
                  .collect(Collectors.toList());

          List<Integer> sellingIds=bids.stream().map(BidEntity::getSellingId).collect(Collectors.toList());

// Retrieve all users based on the extracted userIds
          List<UserDetailsEntity> users = userRepository.findAllById(userIds);
          List<VehicleEntity> vehicles = sellingAddRepository.findAllById(sellingIds);

          response.setMessage("Success");
          response.setStatus(200);
          response.setBidData(bids);
          response.setUserDetailsList(users);
          response.setVehicleList(vehicles);
      }
        catch (Exception e){
            response.setMessage("Error "+e.getMessage());
            response.setStatus(400);
        }
        return response;
    }

}
