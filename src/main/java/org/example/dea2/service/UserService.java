package org.example.dea2.service;

import org.example.dea2.dto.request.LoginApiRequest;
import org.example.dea2.dto.request.SignUpApiRequest;
import org.example.dea2.dto.response.ApiResponse;

/**
 * Service interface for user-related operations such as user sign-up and login.
 * It defines the methods that will be implemented in the service implementation class.
 */
public interface UserService {

    /**
     * Handles user registration.
     * This method takes a SignUpApiRequest object that contains user information,
     * such as name, email, and password, and returns an ApiResponse.
     * The response may include user details including the userId.
     *
     * @param request the sign-up request containing user details (name, email, password)
     * @return ApiResponse indicating success or failure of the registration process
     */
    ApiResponse userSignUp(SignUpApiRequest request);

    /**
     * Handles user login.
     * This method takes a LoginApiRequest object that contains the user's email
     * and password, and returns an ApiResponse.
     * The response will indicate whether the login was successful, and may include
     * user details including the userId.
     *
     * @param request the login request containing email and password
     * @return ApiResponse indicating success or failure of the login process
     */
    ApiResponse userLogin(LoginApiRequest request);
}
