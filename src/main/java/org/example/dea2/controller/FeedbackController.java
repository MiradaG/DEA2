package org.example.dea2.controller;

import org.example.dea2.dto.request.FeedbackApiRequest;
import org.example.dea2.dto.response.ApiResponse;
import org.example.dea2.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @PostMapping("/save")


    public ApiResponse save(@RequestBody FeedbackApiRequest request){

        return feedbackService.save(request);
    }

    @GetMapping("/view")

    public ApiResponse view(){
        return  feedbackService.view();
    }

}
