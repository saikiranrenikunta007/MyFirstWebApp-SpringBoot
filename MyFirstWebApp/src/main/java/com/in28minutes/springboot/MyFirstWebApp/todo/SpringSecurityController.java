package com.in28minutes.springboot.MyFirstWebApp.todo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;
@Configuration
public class SpringSecurityController {

    @Bean
    public InMemoryUserDetailsManager Builder()
    {

        UserDetails userdetails1=createNewUser("saikiran","Saikiran2511");
        UserDetails userdetails2=createNewUser("renikunta","Saikiran2511");
        return new InMemoryUserDetailsManager(userdetails1,userdetails2);
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    public  UserDetails createNewUser(String username, String password)
    {
        Function<String, String> passwordencoder=input->passwordEncoder().encode(input);
        UserDetails userdetails = User.builder()
                .passwordEncoder(passwordencoder)
                .username(username)
                .password(password)
                .roles("admin", "user")
                .build();
        return userdetails;
    }
    @Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth-> auth.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());
        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();
    }

}
