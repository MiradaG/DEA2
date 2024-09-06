package org.example.dea2.dto.response;


// Importing necessary packages and classes
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter  // Generates getter methods for all fields using Lombok
@Setter  // Generates setter methods for all fields using Lombok
@ToString  // Generates a toString() method using Lombok
public class Response {
    private int status;
    private String message;

    @JsonIgnore  // Ignores this field from JSON
    private String statusCode;
    @JsonIgnore
    private String statusDesc;
}
