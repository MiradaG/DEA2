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


    @Override
    public ApiResponse userSignUp(SignUpApiRequest request) {
        ApiR
