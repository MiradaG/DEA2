package org.example.dea2.service.serviceImpl;

import org.example.dea2.repository.SellingAddRepository;
import org.example.dea2.service.SellingService;
import org.example.dea2.dto.request.SellingAddApiRequest;
import org.example.dea2.dto.response.ApiResponse;
import org.example.dea2.entity.VehicleEntity;
import org.example.dea2.entity.UserDetailsEntity;
import org.example.dea2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellingServiceImpl implements SellingService {
    @Autowired
    private SellingAddRepository sellingAddRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public ApiResponse add(SellingAddApiRequest request) {
        Optional<UserDetailsEntity> byId = userRepository.findById(request.getUserId());
        ApiResponse response = new ApiResponse();
        if(byId.isPresent()) {
            VehicleEntity vehicleEntity = new VehicleEntity();
            vehicleEntity.setBidAmount(request.getBidAmount());
            vehicleEntity.setUser(byId.get());
            vehicleEntity.setDescription(request.getDescription());
            vehicleEntity.setYear(request.getYear());
            vehicleEntity.setEndDate(request.getEndDate());
            vehicleEntity.setStartDate(request.getStartDate());
            vehicleEntity.setVehicleName(request.getVehicleName());
            vehicleEntity.setImagePath(request.getImagePath());

            sellingAddRepository.save(vehicleEntity);
            response.setMessage("Successfully saved the vehicle");
            response.setStatus(200);
            return  response;
        }





        response.setMessage("Failed to list the vehicle");
        response.setStatus(400);




        return response;
    }

    @Override
    public ApiResponse get() {
        List<VehicleEntity> all = sellingAddRepository.findAll();
        System.out.printf(all.toString());
        ApiResponse response = new ApiResponse();
        response.setStatus(200);
        response.setVehicleList(all);
        return response;
    }

    @Override
    public ApiResponse delete(String vehicleId) {
        Optional<VehicleEntity> byId = sellingAddRepository.findById(Integer.valueOf(vehicleId));
        System.out.printf(byId.toString());
        ApiResponse response = new ApiResponse();
        if(byId.isPresent()) {
            sellingAddRepository.delete(byId.get());
            response.setMessage("Successfully deleted the vehicle");
            response.setStatus(200);
            return response;
        }
        response.setMessage("Failed to delete the vehicle");
        response.setStatus(400);
        return response;
    }

    @Override
    public ApiResponse update(SellingAddApiRequest request) {
        Optional<VehicleEntity> byId = sellingAddRepository.findById(request.getVehicleId());
        ApiResponse response = new ApiResponse();
        if(byId.isPresent()) {
            VehicleEntity vehicleEntity = byId.get();
            vehicleEntity.setBidAmount(request.getBidAmount());
            vehicleEntity.setDescription(request.getDescription());
            vehicleEntity.setYear(request.getYear());
            vehicleEntity.setEndDate(request.getEndDate());
            vehicleEntity.setStartDate(request.getStartDate());
            vehicleEntity.setVehicleName(request.getVehicleName());
            vehicleEntity.setImagePath(request.getImagePath());
            sellingAddRepository.save(vehicleEntity);

            response.setMessage("Successfully updated the vehicle");
            response.setStatus(200);
            return response;
        }
        response.setMessage("Failed to update the vehicle");
        response.setStatus(400);
        return response;
    }
}
