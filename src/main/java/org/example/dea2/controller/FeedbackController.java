package org.example.dea2.controller;

import org.example.dea2.dto.request.FeedbackApiRequest;
import org.example.dea2.dto.response.ApiResponse;
import org.example.dea2.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin  // Allows cross-origin requests, enabling the API to be called from different domains
@RestController  // Indicates that this class is a RESTful controller and will handle HTTP requests
@RequestMapping("api/v1/feedback")  // Defines the base URL for all endpoints in this controller, "/api/v1/feedback"
public class FeedbackController {

    @Autowired  // Automatically injects an instance of FeedbackService
    private FeedbackService feedbackService;

    // Endpoint to handle saving feedback
    @PostMapping("/save")
    public ApiResponse save(@RequestBody FeedbackApiRequest request) {

        return feedbackService.save(request);
    }

    // Endpoint to handle viewing all feedback
    @GetMapping("/view")  // Maps HTTP GET requests to this method, with the URL "/api/v1/feedback/view"
    public ApiResponse view() {

        return feedbackService.view();
    }
}