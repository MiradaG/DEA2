package org.example.dea2.dto.request;

import lombok.Data;

@Data
public class LoginApiRequest {

    private String email;     // Email of the user
    private String password;  // Password of the user
    private int userId;       // Unique identifier of the user
}
