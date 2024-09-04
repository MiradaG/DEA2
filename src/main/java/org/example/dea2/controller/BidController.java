package org.example.dea2.controller;

import org.example.dea2.dto.request.BidApiRequest;
import org.example.dea2.service.BidService;
import org.example.dea2.dto.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/bid")

public class BidController {
    @Autowired
    private BidService bidService;
    @PostMapping("/save")

    public ApiResponse save(@RequestBody BidApiRequest request) {
        return bidService.save(request);

    }

    @GetMapping("/view")
    public ApiResponse view() {
        return bidService.view();
    }

}
