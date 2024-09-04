package org.example.dea2.controller;

import org.example.dea2.dto.request.LoginApiRequest;
import org.example.dea2.dto.request.SignUpApiRequest;
import org.example.dea2.service.UserService;
import org.example.dea2.dto.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")

public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/registration")
    public ApiResponse userSignUp(@RequestBody SignUpApiRequest request) {
        return userService.userSignUp(request);

    }

    @PostMapping("/login")
    public ApiResponse userLogin(@RequestBody LoginApiRequest request) {
        return userService.userLogin(request);
    }
}
