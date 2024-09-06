package org.example.dea2.service.serviceImpl;

import org.example.dea2.dto.request.FeedbackApiRequest;
import org.example.dea2.dto.response.ApiResponse;
import org.example.dea2.entity.FeedbackEntity;
import org.example.dea2.repository.FeedbackRepository;
import org.example.dea2.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired  // Automatically injects the FeedbackRepository instance
    FeedbackRepository feedbackRepository;

    // Implementation of the save method to handle feedback submission
    @Override
    public ApiResponse save(FeedbackApiRequest request) {
        ApiResponse response = new ApiResponse();  // Create a new API response object

        try {
            // Create a new FeedbackEntity and set its properties from the request object
            FeedbackEntity feedback = new FeedbackEntity();
            feedback.setFeedback(request.getFeedback());
            feedback.setStarValue(request.getStarValue());
            feedback.setUserName(request.getUserName());
            feedback.setUserId(request.getUserId());

            // Save the feedback entity to the database
            feedbackRepository.save(feedback);

            // If successful, set the response message and status to indicate success
            response.setMessage("Success");
            response.setStatus(200);

        } catch (Exception e) {

            response.setMessage("Error: " + e.getMessage());
            response.setStatus(404);
        }


        return response;
    }

    // Implementation of the view method to retrieve all feedback entries
    @Override
    public ApiResponse view() {
        ApiResponse response = new ApiResponse();  // Create a new API response object

        try {

            List<FeedbackEntity> feedbackList = feedbackRepository.findAll();

            // Add the list of feedback to the response
            response.setFeedbackList(feedbackList);

            // If successful, set the response message and status to indicate success
            response.setMessage("Success");
            response.setStatus(200);

        } catch (Exception e) {
            // If an error occurs, catch the exception and set an error message and status
            response.setMessage("Error: " + e.getMessage());
            response.setStatus(404);
        }


        return response;
    }
}
