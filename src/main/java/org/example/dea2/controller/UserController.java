package org.example.dea2.controller;

// Importing necessary packages and classes
import org.example.dea2.dto.request.FeedbackApiRequest;
import org.example.dea2.dto.response.ApiResponse;
import org.example.dea2.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Allowing cross-origin requests to this controller
@CrossOrigin
// Marking this class as a REST controller for handling HTTP requests
@RestController
// Defining the base URL path for this controller
@RequestMapping("api/v1/feedback")
public class FeedbackController {


    @Autowired
    private FeedbackService feedbackService;

    /**
     * Endpoint to save feedback.
     * Handles HTTP POST requests sent to "/api/v1/feedback/save".
     */
    @PostMapping("/save")
    public ApiResponse save(@RequestBody FeedbackApiRequest request) {

        return feedbackService.save(request);
    }

    /**
     * Endpoint to view all feedback.
     */
    @GetMapping("/view")
    public ApiResponse view() {
        // Delegating the view operation to the FeedbackService and returning the response
        return feedbackService.view();
    }
}