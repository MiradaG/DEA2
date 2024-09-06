package org.example.dea2.service;

import org.example.dea2.dto.request.SellingAddApiRequest;
import org.example.dea2.dto.response.ApiResponse;


//SellingService defines the business logic contract for handling vehicle-related operations.
//This includes adding, retrieving, deleting, and updating vehicles in the system.

public interface SellingService {

    //Adds a new vehicle to the system.
    ApiResponse add(SellingAddApiRequest request);

    //Retrieves all vehicles from the system.
    ApiResponse get();

    //Deletes a vehicle from the system by its ID.
    ApiResponse delete(String vehicleId);

    //Updates an existing vehicle's information in the system.
    ApiResponse update(SellingAddApiRequest request);
}
