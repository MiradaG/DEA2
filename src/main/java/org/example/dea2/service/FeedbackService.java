package org.example.dea2.service;

import org.example.dea2.dto.request.FeedbackApiRequest;
import org.example.dea2.dto.response.ApiResponse;

public interface FeedbackService {
    ApiResponse save(FeedbackApiRequest request);

    ApiResponse view();
}
