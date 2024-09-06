package org.example.dea2.controller;

import org.example.dea2.service.SellingService;
import org.example.dea2.dto.request.SellingAddApiRequest;
import org.example.dea2.dto.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin // Allow cross-origin requests (necessary when the frontend and backend are on different domains)
@RestController // Marks this class as a REST controller
@RequestMapping("/api/v1/selling") // Base URL for all API endpoints in this controller
public class VehicleController {
    @Autowired
    private SellingService sellingService; // Injects the SellingService to handle business logic


    //Adds a new vehicle for selling.
    @PostMapping("/add")
    public ApiResponse add(@RequestBody SellingAddApiRequest request) {
        return sellingService.add(request);
    }

    //Retrieves all vehicles available for selling.
    @GetMapping("/get")
    public ApiResponse get() {
        return sellingService.get();
    }


     //Deletes a vehicle from the selling list by its ID.
    @DeleteMapping("/delete/{vehicleId}")
    public ApiResponse delete(@PathVariable("vehicleId") String vehicleId) {
        return sellingService.delete(vehicleId);
    }

    //Updates vehicle information in the selling list.
    @PutMapping("/update")
    public ApiResponse update(@RequestBody SellingAddApiRequest request) {
        return sellingService.update(request);
    }
}
