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
    @Autowired
    FeedbackRepository feedbackRepository;
    @Override

    public ApiResponse save(FeedbackApiRequest request) {
        ApiResponse response = new ApiResponse();

        try{
            FeedbackEntity feedback = new FeedbackEntity();
            feedback.setFeedback(request.getFeedback());
            feedback.setStarValue(request.getStarValue());
            feedback.setUserName(request.getUserName());
            feedback.setUserId(request.getUserId());
            feedbackRepository.save(feedback);
            response.setMessage("Success");
            response.setStatus(200);


        }
        catch(Exception e){
            response.setMessage("error" + e.getMessage());
            response.setStatus(404);
        }

        return response;
    }

    @Override
    public ApiResponse view() {
        ApiResponse response = new ApiResponse();

        try{
           List<FeedbackEntity> feedbackList = feedbackRepository.findAll();
           response.setFeedbackList(feedbackList);


            response.setMessage("Success");
            response.setStatus(200);


        }
        catch(Exception e){
            response.setMessage("error" + e.getMessage());
            response.setStatus(404);
        }
        return response;
    }
}
