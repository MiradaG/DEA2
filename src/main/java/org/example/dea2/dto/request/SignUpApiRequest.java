package org.example.dea2.dto.request;

import lombok.Data;


@Data // Lombok annotation to automatically generate getter, setter, equals, hashCode, and toString methods.
public class SignUpApiRequest {


    private String email;


    private String password;


    private String Name;
}
