package org.example.dea2.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.dea2.entity.BidEntity;
import org.example.dea2.entity.FeedbackEntity;
import org.example.dea2.entity.VehicleEntity;
import org.example.dea2.entity.UserDetailsEntity;

import java.util.List;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse extends Response {
    private UserDetailsEntity userData;
    private String imageName;
    private List<VehicleEntity> vehicleList;
    private List<BidEntity> bidData;
    private List<UserDetailsEntity> userDetailsList;
    private List<VehicleEntity> vehicleDetailsList;
    private List<FeedbackEntity> feedbackList;

}
