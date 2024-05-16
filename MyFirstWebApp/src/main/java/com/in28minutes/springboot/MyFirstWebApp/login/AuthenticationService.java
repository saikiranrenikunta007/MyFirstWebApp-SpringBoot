package com.in28minutes.springboot.MyFirstWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    Boolean validate(String name,String password)
    {
        return name.equalsIgnoreCase("saikiran") && password.equalsIgnoreCase("Saikiran2511");
    }
}
