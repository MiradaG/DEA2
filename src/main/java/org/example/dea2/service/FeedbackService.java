package org.example.dea2.service;

import org.example.dea2.dto.request.FeedbackApiRequest;
import org.example.dea2.dto.response.ApiResponse;

public interface FeedbackService {

    // Method to save feedback data based on the user's request
    ApiResponse save(FeedbackApiRequest request);

    // Method to retrieve all feedback entries from the system
    ApiResponse view();
}
