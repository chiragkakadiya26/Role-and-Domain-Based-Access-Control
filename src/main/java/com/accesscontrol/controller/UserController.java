package com.accesscontrol.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @GetMapping("/profile")
    public Map<String, String> profile(@AuthenticationPrincipal UserDetails userDetails) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome Profile, " + userDetails.getUsername());
        return response;
    }
}
