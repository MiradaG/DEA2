package org.example.dea2.dto.request;

import lombok.Data;

@Data  // Lombok annotation that automatically generates getters, setters, toString, equals, and hashCode methods
public class FeedbackApiRequest {
    private int userId;
    private String feedback;
    private String userName;
    private int starValue;
}
