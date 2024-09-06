package org.example.dea2.dto.request;

import lombok.Data;


@Data // Lombok annotation to automatically generate getter, setter, equals, hashCode, and toString methods.
public class LoginApiRequest {


    private String email;


    private String password;
}
