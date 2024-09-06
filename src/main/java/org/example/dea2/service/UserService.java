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

     * This method will take a SignUpApiRequest object that contains user information,
     * such as name, email, and password, and return an ApiResponse.
     * @return ApiResponse indicating success or failure of the registration process
     */
    ApiResponse userSignUp(SignUpApiRequest request);

    /**

     * This method will take a LoginApiRequest object that contains the user's email
     * and password, and return an ApiResponse.
     * @return ApiResponse indicating success or failure of the login process
     */
    ApiResponse userLogin(LoginApiRequest request);
}
