package com.devglan.springbootgoogleoauth.controller;

import com.devglan.springbootgoogleoauth.model.User;
import com.devglan.springbootgoogleoauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static com.devglan.springbootgoogleoauth.common.Constants.homeUrl;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/custom-login")
    public String loadLoginPage(){
        return "login";
    }

    @PostMapping("/signup")
    public String login(@ModelAttribute("signup") User user){
        String token = userService.signUp(user);
        return UriComponentsBuilder.fromUriString(homeUrl)
                .queryParam("auth_token", token)
                .build().toUriString();
    }

}
