package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationTest {

    @GetMapping("/")
    public String home() {
        return "<H1>Welcome!<H1>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<H1>Welcome ADMIN!<H1>";
    }


    @GetMapping("/user")
    public String user() {
        return "<H1>Welcome USER!<H1>";
    }

}