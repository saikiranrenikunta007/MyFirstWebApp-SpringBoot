package com.in28minutes.springboot.MyFirstWebApp.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Security;

@Slf4j
@Controller
@SessionAttributes("name")
public class WelcomeContoller {

    /*private final AuthenticationService authenticationService;
    LoginContoller(AuthenticationService authenticationService)
    {
        this.authenticationService=authenticationService;
    }
    @RequestMapping(value="login",method=RequestMethod.GET)
    public String LoginToPage()
    {
        
//        log.debug("The Request parameter is{ }",name);
        //logger.info("The Request Parameter is {}",name);
        //model.put("name",name);
        return "login";
    }

    @PostMapping(value="login")
    public  String LoginToWelcomePage(@RequestParam String name,@RequestParam String password ,ModelMap model)
    {
        if(authenticationService.validate(name,password))
        {
            model.put("name",name);
            model.put("password",password);
            return "Welcome";
        }
        model.put("errorMessage","InvalidCredentials!");
        return "login";
    }*/
    @GetMapping(value="/")
    public String gotoWelcomePage(ModelMap model)
    {
        model.put("name",getLoginUsername());
        return "Welcome";
    }
    public String getLoginUsername()
    {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
