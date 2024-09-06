package org.example.dea2.service.serviceImpl;

import org.example.dea2.dto.request.LoginApiRequest;
import org.example.dea2.dto.request.SignUpApiRequest;
import org.example.dea2.dto.response.ApiResponse;
import org.example.dea2.entity.UserDetailsEntity;
import org.example.dea2.repository.UserRepository;
import org.example.dea2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service implementation for user-related operations such as sign-up and login.
 * This class implements the UserService interface.
 */
@Service // Marks this class as a Spring service component, making it eligible for dependency injection.
public class UserServiceImpl implements UserService {

    @Autowired // Automatically injects the UserRepository dependency.
    private UserRepository userRepository;

    // BCryptPasswordEncoder is used to hash passwords securely.
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * Handles user registration.
     * Takes a SignUpApiRequest, encodes the password, and saves the user in the database.
     *
     * @param request the sign-up request containing user details (email, password, name)
     * @return ApiResponse with success or error message
     */
    @Override
    public ApiResponse userSignUp(SignUpApiRequest request) {
        ApiResponse response = new ApiResponse();
        try {
            // Encrypt the user's password using BCrypt.
            String encodedPassword = bCryptPasswordEncoder.encode(request.getPassword());

            // Create a new UserDetailsEntity to save in the database.
            UserDetailsEntity userSave = new UserDetailsEntity();
            userSave.setName(request.getName());
            userSave.setPassword(encodedPassword);
            userSave.setEmail(request.getEmail());

            // Save the user to the database.
            userRepository.save(userSave);

            // Set the response data and message.
            response.setUserData(userSave);
            response.setMessage("User registered successfully");
            response.setStatus(200);

        } catch (Exception e) {
            // Handle any exceptions and set an error response.
            response.setMessage("Error: " + e.getMessage());
            response.setStatus(400);
        }
        return response;
    }

    /**
     * Handles user login.
     * Verifies if the user exists, and checks if the password matches the hashed password.
     *
     * @param request the login request containing email and password
     * @return ApiResponse with success or error message
     */
    @Override
    public ApiResponse userLogin(LoginApiRequest request) {
        ApiResponse response = new ApiResponse();

        try {
            // Find the user by email from the database.
            UserDetailsEntity user = userRepository.findByEmail(request.getEmail());

            if (user != null) {
                // Check if the provided password matches the stored encrypted password.
                if (bCryptPasswordEncoder.matches(request.getPassword(), user.getPassword())) {
                    response.setMessage("Login successful");
                    response.setStatus(200);
                } else {
                    response.setMessage("Login failed");
                    response.setStatus(400);
                }
            } else {
                // If user not found, set response status to 404.
                response.setMessage("User not found");
                response.setStatus(404);
            }

        } catch (Exception e) {
            // Handle exceptions and set an error response.
            response.setMessage("Error: " + e.getMessage());
            response.setStatus(400);
        }
        return response;
    }
}