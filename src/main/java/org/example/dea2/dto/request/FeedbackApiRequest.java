package org.example.dea2.dto.request;

import lombok.Data;

@Data
public class FeedbackApiRequest {
    private int userId;
    private String feedback;
    private String userName;
    private int starValue;
}
