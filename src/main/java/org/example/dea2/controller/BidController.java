package org.example.dea2.controller;

import org.example.dea2.dto.request.BidApiRequest;
import org.example.dea2.service.BidService;
import org.example.dea2.dto.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // Marks the class as a controller where every method returns a response body.
@CrossOrigin // Enables Cross-Origin Resource Sharing (CORS) for handling requests from different domains.
@RequestMapping("/api/v1/bid") // Base URL for all bid-related API requests.

public class BidController {

    @Autowired // Automatically injects the BidService dependency.
    private BidService bidService;

    /**
     * API to save a new bid.
     *
     * @param request The bid details sent in the request body.
     * @return ApiResponse containing the status and result of the save operation.
     */
    @PostMapping("/save") // Maps HTTP POST requests to this method.
    public ApiResponse save(@RequestBody BidApiRequest request) {
        return bidService.save(request);
    }

    /**
     * API to view all bids.
     *
     * @return ApiResponse containing the list of bids or other related data.
     */
    @GetMapping("/view") // Maps HTTP GET requests to this method.
    public ApiResponse view() {
        return bidService.view();
    }
}
