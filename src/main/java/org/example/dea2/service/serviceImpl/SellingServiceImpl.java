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



@Service // Marks this class as a service component in the Spring context
public class SellingServiceImpl implements SellingService {

    @Autowired
    private SellingAddRepository sellingAddRepository; // Repository for vehicle-related operations

    @Autowired
    private UserRepository userRepository; // Repository for user-related operations

    //Adds a new vehicle listing if the user exists in the system.
    @Override
    public ApiResponse add(SellingAddApiRequest request) {
        Optional<UserDetailsEntity> byId = userRepository.findById(request.getUserId());
        ApiResponse response = new ApiResponse();

        // Check if the user exists
        if (byId.isPresent()) {
            // Create and populate VehicleEntity with data from the request
            VehicleEntity vehicleEntity = new VehicleEntity();
            vehicleEntity.setBidAmount(request.getBidAmount());
            vehicleEntity.setUser(byId.get());
            vehicleEntity.setDescription(request.getDescription());
            vehicleEntity.setYear(request.getYear());
            vehicleEntity.setEndDate(request.getEndDate());
            vehicleEntity.setStartDate(request.getStartDate());
            vehicleEntity.setVehicleName(request.getVehicleName());
            vehicleEntity.setImagePath(request.getImagePath());

            // Save the vehicle data
            sellingAddRepository.save(vehicleEntity);
            response.setMessage("Successfully saved the vehicle");
            response.setStatus(200);
            return response;
        }

        response.setMessage("Failed to list the vehicle");
        response.setStatus(400);
        return response;
    }

    //Retrieves all vehicle listings from the repository.
    @Override
    public ApiResponse get() {
        List<VehicleEntity> all = sellingAddRepository.findAll();
        System.out.println(all.toString()); // Debugging output

        ApiResponse response = new ApiResponse();
        response.setStatus(200);
        response.setVehicleList(all); // Set the retrieved vehicle list in the response
        return response;
    }

    //Deletes a vehicle listing based on its ID.
    @Override
    public ApiResponse delete(String vehicleId) {
        Optional<VehicleEntity> byId = sellingAddRepository.findById(Integer.valueOf(vehicleId));
        System.out.println(byId.toString()); // Debugging output

        ApiResponse response = new ApiResponse();
        if (byId.isPresent()) {
            // Delete the vehicle if found
            sellingAddRepository.delete(byId.get());
            response.setMessage("Successfully deleted the vehicle");
            response.setStatus(200);
            return response;
        }
        response.setMessage("Failed to delete the vehicle");
        response.setStatus(400);
        return response;
    }

    //Updates an existing vehicle listing if found in the repository.
    @Override
    public ApiResponse update(SellingAddApiRequest request) {
        Optional<VehicleEntity> byId = sellingAddRepository.findById(request.getVehicleId());
        ApiResponse response = new ApiResponse();

        if (byId.isPresent()) {
            // Update the vehicle entity with new values
            VehicleEntity vehicleEntity = byId.get();
            vehicleEntity.setBidAmount(request.getBidAmount());
            vehicleEntity.setDescription(request.getDescription());
            vehicleEntity.setYear(request.getYear());
            vehicleEntity.setEndDate(request.getEndDate());
            vehicleEntity.setStartDate(request.getStartDate());
            vehicleEntity.setVehicleName(request.getVehicleName());
            vehicleEntity.setImagePath(request.getImagePath());

            // Save the updated vehicle data
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
