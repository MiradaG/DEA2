package org.example.dea2.controller;

import org.example.dea2.service.SellingService;
import org.example.dea2.dto.request.SellingAddApiRequest;
import org.example.dea2.dto.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/selling")

public class VehicleController {
    @Autowired
    private SellingService sellingService;
   @PostMapping ("/add")
    public ApiResponse add(@RequestBody SellingAddApiRequest request) {
       return sellingService.add(request);


   }

    @GetMapping ("/get")
    public ApiResponse get() {
        return sellingService.get();
    }

    @DeleteMapping ("/delete/{vehicleId}")
    public ApiResponse delete(@PathVariable("vehicleId") String vehicleId) {
        return sellingService.delete(vehicleId);
    }

    @PutMapping ("/update")
    public ApiResponse delete(@RequestBody SellingAddApiRequest request) {
        return sellingService.update(request);
    }

}
